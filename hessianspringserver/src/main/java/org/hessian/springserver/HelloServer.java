package org.hessian.springserver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by aayongche on 2016/7/6.
 */
public class HelloServer implements ApplicationContextAware {

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public ApplicationContext getCtx() {
        return ctx;
    }

    public void setCtx(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public String getWebXmlPath() {
        return webXmlPath;
    }

    public void setWebXmlPath(String webXmlPath) {
        this.webXmlPath = webXmlPath;
    }

    public String getResourceBase() {
        return resourceBase;
    }

    public void setResourceBase(String resourceBase) {
        this.resourceBase = resourceBase;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    private Server server;

    private ApplicationContext ctx;

    private String webXmlPath;

    private String resourceBase;

    private String contextPath;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void start(){
        WebAppContext wc = new WebAppContext();
        wc.setContextPath(contextPath);
        wc.setDescriptor(webXmlPath);
        wc.setResourceBase(resourceBase);
        wc.setConfigurationDiscovered(true);
        wc.setParentLoaderPriority(true);
        server.setHandler(wc);

        wc.setClassLoader(ctx.getClassLoader());

        XmlWebApplicationContext xctx = new XmlWebApplicationContext();
        xctx.setParent(ctx);
        xctx.setConfigLocation("");
        xctx.setServletContext(wc.getServletContext());
        xctx.refresh();

        wc.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, xctx);
        try {
            server.start();
            System.out.println("server start...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.registerShutdownHook();
    }
}

package org.hessian.server;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.hessian.server.impl.HelloServiceImpl;

import java.nio.channels.SelectionKey;

/**
 * Created by aayongche on 2016/7/6.
 */
public class HessianServer {

    public static final int PORT = 8889;
    public void startServer(){
        Server server = new Server();
        ServerConnector serverConnector = new ServerConnector(server);
        serverConnector.setPort(PORT);
        server.setConnectors(new Connector[]{serverConnector});

        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath("/");

        ServletHolder servletHolder = new ServletHolder(new HelloServiceImpl());
        servletContextHandler.addServlet(servletHolder, "/hello");

        server.setHandler(servletContextHandler);
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new HessianServer().startServer();
    }
}

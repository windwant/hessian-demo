package org.hessian.springclient;

import com.caucho.hessian.client.HessianProxyFactory;
import org.hessian.common.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;

/**
 * Created by windwant on 2016/7/6.
 */
public class HessianClient {
    public static void main(String[] args) {
        springProxy();
    }

    public static void springProxy(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        HelloService helloService = (HelloService) ctx.getBean("hessianClient");
        System.out.println(helloService.hello("lilei"));
    }

    public static void hessianProxy(){
        String URL = "http://localhost:8889/hessian/hello.hess";
        HessianProxyFactory hessianProxyFactory = new HessianProxyFactory();
        HelloService helloService = null;
        try {
            helloService = (HelloService) hessianProxyFactory.create(HelloService.class, URL);
            System.out.println(helloService.hello("lilei"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

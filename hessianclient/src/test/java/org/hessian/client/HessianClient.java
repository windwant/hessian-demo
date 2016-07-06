package org.hessian.client;

import com.caucho.hessian.client.HessianProxyFactory;
import org.hessian.server.HelloService;

import java.net.MalformedURLException;

/**
 * Created by aayongche on 2016/7/6.
 */
public class HessianClient {

    public static final String URL = "http://localhost:8889/hello";

    public static void main(String[] args) {
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

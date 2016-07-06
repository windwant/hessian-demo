package org.hessian.server.impl;

import com.caucho.hessian.server.HessianServlet;
import org.hessian.server.HelloService;

/**
 * Created by aayongche on 2016/7/5.
 */
public class HelloServiceImpl extends HessianServlet implements HelloService {
    public String hello(String name) {
        return String.format("%s say hello!", name);
    }
}

package org.hessian.springserver.impl;

import org.hessian.common.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by aayongche on 2016/7/5.
 */
@Service("helloSvr")
public class HelloServiceImpl implements HelloService {
    public String hello(String name) {
        return String.format("%s say hello!", name);
    }
}

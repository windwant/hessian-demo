package org.hessian.springserver.impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.mock.http.client.MockClientHttpRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/** 
* HelloServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮһ�� 9, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@ContextConfiguration(value = "classpath*: resources/applicationContext.xml")
public class HelloServiceImplTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 
@Bean
public RestTemplate restTemplate(){
    return new RestTemplate();
}
/** 
* 
* Method: hello(String name) 
*
 * roger
 *
 *
*/
@Test
public void testHello() throws Exception { 
    //TODO: Test goes here...
    System.out.println(restTemplate().getForObject("http://www.baidu.com", String.class));
    System.out.println(restTemplate().postForObject("http://www.baidu.com", null, String.class));
}


} 

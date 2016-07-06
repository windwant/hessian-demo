package org.hessian.server;

import junit.framework.TestCase;

import java.io.RandomAccessFile;
import java.util.Calendar;

/**
 * Created by aayongche on 2016/7/6.
 */
public class Test extends TestCase {

    public void test(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 11, 01);
        System.out.println(calendar.getTime().toString());
        calendar.add(Calendar.MONTH, 1);
        System.out.println(calendar.getTime().toString());
    }

}

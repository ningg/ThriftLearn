package com.meituan.guoning.learn;

import org.apache.thrift.TException;

/**
 * Created by guoning on 16/2/14.
 */
public class HelloServiceImpl implements Hello.Iface {
    @Override
    public String helloString(String param) throws TException {
        System.out.println("Input String is: " + param);
        return param;
    }

    @Override
    public int helloInt(int param) throws TException {
        return param;
    }

    @Override
    public boolean helloBoolean(boolean param) throws TException {
        return param;
    }

    @Override
    public void helloVoid() throws TException {
        System.out.println("Hello Void!");
    }

    @Override
    public String helloNull() throws TException {
        return null;
    }

    @Override
    public person helloPerson() throws TException {
        return null;
    }
}

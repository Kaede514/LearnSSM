package com.kaede.spring.test;

import com.kaede.spring.proxy.Caculator;
import com.kaede.spring.proxy.CaculatorStaticProxy;
import com.kaede.spring.proxy.ProxyFactory;
import com.kaede.spring.proxy.impl.CaculatorImpl;
import org.junit.Test;

/**
 * @author kaede
 * @create 2022-07-24 14:51
 */

public class ProxyTest {

    /**
     * 动态代理有两种：
     * 1、jdk动态代理，要求必须有接口，最终生成的代理类和目标类实现相同的接口，
     *      在com.sun.proxy包下，类名为$proxy+数字
     * 2、cglib动态代理，最终生成的代理类会继承目标类，并且和目标类在相同的包下
     */

    @Test
    public void testProxy() {
        //CaculatorStaticProxy proxy = new CaculatorStaticProxy(new CaculatorImpl());
        //proxy.add(1, 2);

        ProxyFactory proxyFactory = new ProxyFactory(new CaculatorImpl());
        Caculator proxy = (Caculator) proxyFactory.getProxy();
        proxy.add(1, 2);


    }
}

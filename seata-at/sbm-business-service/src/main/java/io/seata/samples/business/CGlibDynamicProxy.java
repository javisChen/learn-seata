package io.seata.samples.business;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CGlibDynamicProxy {

    public static class ProxyHandler implements MethodInterceptor {
        Object object;

        public ProxyHandler(Object o) {
            this.object = o;
        }

        public Object intercept(Object o, Method method, Object[] objects, net.sf.cglib.proxy.MethodProxy methodProxy) throws Throwable {
            Object result = null;
            System.out.println("可以在调用实际方法前做一些事情");
            System.out.println("当前调用的方法是" + method.getName());
            result = method.invoke(object, objects);// 需要指定被代理对象和传入参数
            System.out.println(method.getName() + "方法的返回值是" + result);
            System.out.println("可以在调用实际方法后做一些事情");
            System.out.println("------------------------");
            return result;// 返回method方法执行后的返回值
        }
    }

    public interface IPay {

        void pay();

    }

    public interface IBuy {

        void buy();

    }

    public static class AliPay implements IPay {

        public void pay() {
            System.out.println("doing alipay");
        }
    }

    public static void main(String[] args) {
        AliPay aliPay = new AliPay();
        ProxyHandler proxyHandler = new ProxyHandler(aliPay);
        Enhancer enhancer = new Enhancer();
        //设置需要创建子类的类
        enhancer.setSuperclass(AliPay.class);
        enhancer.setCallback(proxyHandler);
        //通过字节码技术动态创建子类实例
        AliPay pay = (AliPay) enhancer.create();
        pay.pay();
    }
}

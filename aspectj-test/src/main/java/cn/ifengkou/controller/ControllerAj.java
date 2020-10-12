package cn.ifengkou.controller;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2020/9/10
 */
//@Aspect
public class ControllerAj {
    //@Around("execution( * cn.ifengkou.controller.TestAjController.ttl(..))")
    public Object inspectMethod(ProceedingJoinPoint pjp) throws Throwable {
        return "Hello,Aspectj";
    }
}

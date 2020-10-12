package cn.ifengkou;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2020/8/27
 */
@Aspect
public class CalcAspectj {
    @Around("execution( * cn.ifengkou.Calc.sum(..))")
    public Object inspectMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("AroundAspectj工程织入in。");

        //AspectJ使用org.aspectj.lang.JoinPoint接口表示目标类连接点对象
        //获取连接点的方法签名对象
        pjp.getSignature();
        String className = pjp.getSignature().getDeclaringTypeName();
        System.out.println("拦截执行的类："+className);
        System.out.println("拦截执行的对象："+pjp.getSignature().getName());
        //获取连接点方法运行时的入参列表
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("参数"+i+":"+String.valueOf(args[i]));
        }
        System.out.println("原计划执行"+args[0]+"+"+args[1]+"=?");

        //获取连接点所在的目标对象；
        pjp.getTarget();
        //获取代理对象本身；
        pjp.getThis();

        //ProceedingJoinPoint继承JoinPoint子接口，它新增了两个用于执行连接点方法的方法：
        //通过反射执行目标对象的连接点处的方法；
        //Object ret = pjp.proceed();
        System.out.println("让我们修改参数。修改后结果为5.7");
        Object ret = pjp.proceed(new Object[]{2.2,3.5});
        System.out.println("AroundAspectj工程织入out");
        return ret;
    }
}

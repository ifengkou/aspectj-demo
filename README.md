# AspectJ 三种织入时机测试

## 工程说明

```bash
.
├── aspectj-test
├── origin-java
├── origin-springboot
├── origin-springboot-web
└── pom.xml

```

- aspectj-test：编织工程
- origin-* ： 为3个不同类型的源工程
  - origin-java： 普通的java工程
  - origin-springboot： springboot工程
  - origin-springboot-web： springboot-web工程
  
备注：各个工程都是独立工程，测试时请单独打包

origin-* 工程主要功能只有一个，就是在工程启动时，调用Calc.sum 求和方法。
origin-springboot-web 工程多了一个API，增加对controller 中的接口进行织入测试


求和方法：
```java
public class Calc {
    public static double sum(double s1,double s2){
        System.out.println("求和 "+s1+"+"+s2+"="+String.valueOf(s1+s2));
        return s1+s2;
    }
}
```

接口
```java
@RestController
public class TestAjController {
    @GetMapping("/ttl")
    public String ttl(){
        System.out.println("expect: hello world");
        return "hello world";
    }
}
```

接下来就借助Aspectj技术，对这几个origin-*工程进行功能织入，改变其运行逻辑

## Aspectj 织入技术

Aspectj静态编织，有三种织入时机，分别为编译时织入、编译后织入、加载时织入

compile-time-Weaving：编译期织入，将aspectj类和目标类放在一起用ajc 编译，直接编译出包含织入代码的 .class 文件
post-compile-Weaving：编译后织入，目标工程已经被打成jar包了，这时候也可以用ajc命令将jar再织入一次。增强已经编译出来的类，如我们要增强依赖的 jar 包中的某个类的某个方法
Load-Time-Weaving：类加载期织入，也简称LTW，在 JVM 进行类加载的时候做字节码的替换，完成织入

该工程代码主要为了测试 该三种织入时机对 普通java工程、springboot工程、springboot-web工程的织入效果

更多技术细节和测试结果，见具体的文章描述吧： https://blog.95id.com/magic_in_java_aspectj.html
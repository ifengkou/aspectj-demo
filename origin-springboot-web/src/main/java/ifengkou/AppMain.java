package ifengkou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2020/10/12
 */
@SpringBootApplication
public class AppMain {
    public static void main(String[] args) throws InterruptedException, IOException {
        SpringApplication.run(AppMain.class, args);

        double sum = Calc.sum(2.3,2.5);
        System.out.println("调用端获取的结果："+String.valueOf(sum));

        System.out.println("执行完毕");
    }
}

package ifengkou.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2020/9/10
 */
@RestController
public class TestAjController {
    @GetMapping("/ttl")
    public String ttl(){
        System.out.println("expect: hello world");
        return "hello world";
    }
}

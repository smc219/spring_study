package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    public String hello(Model model) {
        model.addAttribute("data", "hello!"); // data를 실어서 넘길 수 있다.
        return "hello"; // 스프링부트의 타임리프가 페이지를 찾아서 고칠 수 있도록 수정해주고 있다.

    }
}

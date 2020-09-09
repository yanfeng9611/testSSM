package club.yanfeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String userLogin() {
        return "/User/login";
    }

    @RequestMapping("/adminLogin")
    public String adminLogin() {
        return "/Admin/login";
    }


}

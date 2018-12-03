package com.example.zj.company.controller;

import com.example.zj.company.config.WebSecurityConfig;
import com.example.zj.company.domain.User;
import com.example.zj.company.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
        return "redirect:/company/get";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginPost")
    public @ResponseBody Map<String, Object> loginPost(String account, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        User user = userRepository.getUserByUsername(account);
        if (!password.equals(user.getPassword())) {
            map.put("success", false);
            map.put("message", "密码错误");
            return map;
        }
        session.setAttribute(WebSecurityConfig.SESSION_KEY, account);
        map.put("success", true);
        map.put("message", "登录成功");
        return map;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
}

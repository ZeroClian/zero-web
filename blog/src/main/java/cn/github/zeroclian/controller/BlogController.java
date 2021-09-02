package cn.github.zeroclian.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qiyiguo
 * @Date: 2021-09-02 11:15 上午
 */
@RestController
@RequestMapping("/login")
public class BlogController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}

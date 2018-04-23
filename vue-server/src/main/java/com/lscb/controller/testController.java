package com.lscb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 90902 on 2018/4/22.
 */
@RestController
@RequestMapping("/")
public class testController {

    @RequestMapping("/test")
    public String hello() {
        return "Hello";
    }
}

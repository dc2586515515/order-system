package com.dc.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author DC
 * @Date 2020-03-31
 */
@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Value("${server.port}")
    private String port;

    @GetMapping("index")
    public String index() {
        return "order的端口为：" + port;
    }
}
package com.dc.client.controller;

import com.dc.client.entity.MenuVO;
import com.dc.client.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author DC
 * @Date 2020-03-31
 */
@Controller
@RequestMapping("/client")
public class MenuHandler {
    @Autowired
    private MenuFeign menuFeign;

    /**
     * 转发页面
     * @param path
     * @return
     */
    @GetMapping("/redirect/{path}")
    public String redirect(@PathVariable("path") String path) {
        return path;
    }

    @GetMapping("/menu")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit;
        return menuFeign.findAll(index, limit);
    }
}

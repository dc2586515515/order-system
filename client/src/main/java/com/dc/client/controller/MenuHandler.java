package com.dc.client.controller;

import com.dc.client.entity.Menu;
import com.dc.client.entity.MenuVO;
import com.dc.client.feign.MenuFeign;
import com.dc.client.feign.TypeFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author DC
 * @Date 2020-03-31
 */
@Controller
@RequestMapping("/menu")
public class MenuHandler {
    @Autowired
    private MenuFeign menuFeign;
    @Autowired
    private TypeFeign typeFeign;

    /**
     * 转发页面
     *
     * @param path
     * @return
     */
    @GetMapping("/redirect/{path}")
    public String redirect(@PathVariable("path") String path) {
        return path;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit;
        MenuVO menuVO = menuFeign.findAll(index, limit);
        return menuVO;
    }

    @RequestMapping("/deleteById")
    public String deleteById(@RequestParam("id") String id) {
        menuFeign.deleteById(id);
        return "redirect:/client/redirect/index";
    }

    /**
     * 跳转增加菜品 页
     *
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("list", typeFeign.findAllTypes());
        return "menu_add";
    }

    /**
     * 新增菜品
     *
     * @param menu
     * @return
     */
    @PostMapping("/save")
    public String save(Menu menu) {
        menuFeign.save(menu);
        return "redirect:/menu/redirect/index";
    }


    /**
     * 跳转修改菜品 页
     *
     * @param id
     * @return
     */
    @GetMapping("/findById")
    public String findById(@RequestParam("id") String id, Model model) {
        model.addAttribute("menu", menuFeign.findById(id));
        model.addAttribute("list", typeFeign.findAllTypes());
        return "menu_update";
    }

    @PostMapping("/update")
    public String update(Menu menu) {
        menuFeign.update(menu);
        return "redirect:/menu/redirect/index";
    }
}

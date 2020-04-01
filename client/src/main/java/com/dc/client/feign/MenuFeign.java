package com.dc.client.feign;

import com.dc.client.entity.Menu;
import com.dc.client.entity.MenuVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Description
 * @Author DC
 * @Date 2020-03-31
 */
@FeignClient(value = "menu")
public interface MenuFeign {
    @GetMapping("/menu/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") String id);

    @PostMapping("/menu/save")
    public void save(@RequestBody Menu menu);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") String id);

    @PutMapping("/menu/update")
    public void update(@RequestBody Menu menu);

}

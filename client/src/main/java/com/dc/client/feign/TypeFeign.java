package com.dc.client.feign;

import com.dc.client.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Description
 * @Author DC
 * @Date 2020-04-01
 */
@FeignClient(value = "menu")
public interface TypeFeign {

    @GetMapping("/menu/findAllTypes")
    public List<Type> findAllTypes();
}

package com.dc.menu.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author DC
 * @Date 2020-03-31
 */
@Data
public class MenuVO {
    private int code;
    private String msg;
    private int count;
    private List<Menu> data;


}

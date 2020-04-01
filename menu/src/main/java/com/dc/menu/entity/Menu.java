package com.dc.menu.entity;

import lombok.Data;

/**
 * @Description
 * @Author DC
 * @Date 2020-03-31
 */
@Data
public class Menu {
    private long id;
    private String name;
    private double price;
    private String flavor;
    private String tname;
    private String tid;
    private Type type;
}

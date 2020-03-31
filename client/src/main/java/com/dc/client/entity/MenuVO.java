package com.dc.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description
 * @Author DC
 * @Date 2020-03-31
 */
@Data
@AllArgsConstructor //使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor //使用后创建一个无参构造函数
public class MenuVO {
    private int code;
    private String msg;
    private int count;
    private List<Menu> data;
}

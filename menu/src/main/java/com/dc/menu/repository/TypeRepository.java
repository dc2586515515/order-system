package com.dc.menu.repository;

import com.dc.menu.entity.Type;

import java.util.List;

/**
 * @Description
 * @Author DC
 * @Date 2020-04-01
 */
public interface TypeRepository {
    public List<Type> findAll();
}

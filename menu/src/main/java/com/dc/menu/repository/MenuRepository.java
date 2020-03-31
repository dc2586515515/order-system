package com.dc.menu.repository;

import com.dc.menu.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author DC
 * @Date 2020-03-31
 */
public interface MenuRepository {
    public List<Menu> findAll(@Param("param1") int index, @Param("param2") int limit);

    public int count();

    public void save(Menu menu);

    public Menu findById(long id);

    public void update(Menu menu);

    public void deleteById(long id);
}

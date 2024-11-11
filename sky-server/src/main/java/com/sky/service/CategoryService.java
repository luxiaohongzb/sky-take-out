package com.sky.service;



import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;


public  interface CategoryService {


    /**
     * 修改分类
     * @param categoryDTO
     */
    void updateCategory(CategoryDTO categoryDTO);


    /**
     * 启用或者禁用分类
     * @param id
     */
    void startOrStop(Integer id,Integer status);


    /**
     * 分类分页查询
     *
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 保存新的分类
     * @param categoryDTO
     */
    void save(CategoryDTO categoryDTO);


    /**
     * 根据分类查询菜品
     * @param type
     * @return
     */
    List<Category> list(Integer type);
}

package com.sky.service;



import com.sky.dto.CategoryDTO;
import org.springframework.stereotype.Service;


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
}

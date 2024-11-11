package com.sky.controller.admin;


import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Api(tags = "分类相关接口")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    @ApiOperation("新增分类")
    public Result save(CategoryDTO categoryDTO){
        categoryService.save(categoryDTO);
        return Result.success();
    }
    @PutMapping
    @ApiOperation("修改分类")
    public Result updateCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.updateCategory(categoryDTO);
        return Result.success();
    }
    @PostMapping("/status/{status}")
    @ApiOperation("启用或禁用分类")
    public Result startOrStop(@PathVariable Integer status,Integer id){
        categoryService.startOrStop(id,status);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public  Result<PageResult> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO){
        PageResult result =  categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(result);
    }
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type){
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }
}

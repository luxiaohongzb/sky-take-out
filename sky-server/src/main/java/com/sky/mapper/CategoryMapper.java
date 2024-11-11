package com.sky.mapper;


import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CategoryMapper {


    @AutoFill(OperationType.UPDATE)
    void update(Category category);

    @AutoFill(OperationType.UPDATE)
    @Update("update category set status = #{status} where id = #{id}")
    void forbiddenById(Integer id, Integer status);


    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);


    @Insert("insert into category (type, name, sort, status, create_time, update_time, create_user, update_user) values "
    +  "(#{type}, #{name}, #{sort}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})"
    )
    @AutoFill(OperationType.INSERT)
    void save(Category category);


    @Select("select * from category where type = #{type}")
    List<Category> findItemsByType(Integer type);
}

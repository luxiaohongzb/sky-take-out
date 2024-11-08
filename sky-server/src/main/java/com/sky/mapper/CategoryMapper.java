package com.sky.mapper;


import com.sky.annotation.AutoFill;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CategoryMapper {


    @AutoFill(OperationType.UPDATE)
    void update(Category category);




    @AutoFill(OperationType.UPDATE)
    @Update("update category set status = #{status} where id = #{id}")
    void forbiddenById(Integer id, Integer status);
}

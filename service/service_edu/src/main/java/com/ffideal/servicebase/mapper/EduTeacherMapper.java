package com.ffideal.servicebase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ffideal.servicebase.entity.EduTeacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ffideal
 * @CreateTime: 2022-08-14  14:04
 * @Description: TODO
 * @Version: 1.0
 */
@Mapper
@Repository
public interface EduTeacherMapper extends BaseMapper<EduTeacher>{

    @Select("select * from edu_teacher")
    List<EduTeacher> findAllTeacher();

    @Select("select * from tb_user where id = #{id}")
    EduTeacher findById(@Param("id") Long id);

    @Delete("UPDATE edu_teacher SET is_deleted=1  WHERE  is_deleted=0  AND id = #{id}")
    boolean deleteTeacherById(String id);

    @Update("update edu_teacher set name = #{name} where is_deleted = 0 and id = #{id}")
    void updateNameById(String id, String name);

    @Select("select * from edu_teacher where id = #{id}")
    EduTeacher findTeacherById(String id);
}

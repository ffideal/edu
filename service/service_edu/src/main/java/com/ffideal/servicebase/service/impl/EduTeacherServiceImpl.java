package com.ffideal.servicebase.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ffideal.servicebase.entity.EduTeacher;
import com.ffideal.servicebase.mapper.EduTeacherMapper;
import com.ffideal.servicebase.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ffideal
 * @CreateTime: 2022-08-14  14:05
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {
//    @Autowired
//    private EduTeacherMapper eduTeacherMapper;
//    @Override
//    public List<EduTeacher> findAllTeacherService() {
//        return eduTeacherMapper.findAllTeacher();
//    }
//
//    @Override
//    public boolean deleteTeacherByIdService(String id) {
//        boolean flag = eduTeacherMapper.deleteTeacherById(id);
//        return flag;
//    }
//
//    @Override
//    public EduTeacher updateNameById(String id, String name) {
//        eduTeacherMapper.updateNameById(id,name);
//        EduTeacher eduTeacher = eduTeacherMapper.findTeacherById(id);
//        return eduTeacher;
//    }
}

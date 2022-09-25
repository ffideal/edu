package com.ffideal.servicebase.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ffideal.servicebase.commonutils.R;
import com.ffideal.servicebase.entity.EduTeacher;
import com.ffideal.servicebase.entity.vo.TeacherQuery;
import com.ffideal.servicebase.exceptionhandler.ByZeroException;
import com.ffideal.servicebase.service.EduTeacherService;
import com.mysql.cj.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ffideal
 * @CreateTime: 2022-08-14  14:02
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/edu/teacher")
@Api(tags = {"教师管理模块TeacherController"})
@CrossOrigin    // 解决跨域
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation("查询所有")
    @GetMapping("/findAll")
    public R findAllTeacherController() {
        List<EduTeacher> list = eduTeacherService.list(null);

        return R.ok().data("items", list);
    }

    @ApiOperation("删除指定id的人")
    @DeleteMapping("/delete/{id}")
    public R deleteTeacherById(@ApiParam("要删除教师的ID") @PathVariable("id") String id) {
        boolean flag = eduTeacherService.removeById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }

    }
//    @ApiOperation("更新数据")
//    @GetMapping("/update")
//    public R deleteTeacherById(@RequestParam("id") String id,
//                                    @RequestParam("name")String name){
//        EduTeacher eduTeacher = eduTeacherService.updateNameById(id,name);
//        return R.ok().data("items", eduTeacher);
//    }

    @ApiOperation("分页查询")
    @GetMapping("/{page}/{limit}")
    public R queryTeachersByPage(@ApiParam("当前页") @PathVariable("page") Long page,
                                 @ApiParam("每页记录数") @PathVariable("limit") Long limit) {
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        eduTeacherService.page(pageParam, null);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", records);
        return R.ok().data(map);
    }

    @ApiOperation("有条件查询")
    @PostMapping("/hasCondition/{page}/{limit}")
    public R queryTeachersByCondition(@ApiParam("当前页") @PathVariable("page") Long page,
                                      @ApiParam("每页记录数") @PathVariable("limit") Long limit,
                                      @ApiParam("传入查询条件") @RequestBody(required = false) TeacherQuery teacherQuery) {
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(page,limit);

        //构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        // 多条件组合查询
        // mybatis学过 动态sql
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //判断条件值是否为空，如果不为空拼接条件
        if (!StringUtils.isNullOrEmpty(name)) {
            wrapper.like("name", name);
        }
        if (level!=null) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isNullOrEmpty(begin)) {
            wrapper.ge("gmt_create",begin);
        }
        if (!StringUtils.isNullOrEmpty(end)) {
            wrapper.le("gmt_create",end);
        }
        wrapper.orderByDesc("gmt_create");
        eduTeacherService.page(pageTeacher, wrapper);
        List<EduTeacher> records = pageTeacher.getRecords();
        long total = pageTeacher.getTotal();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", records);
        return R.ok().data(map);
    }

    @ApiOperation("添加一位教师")
    @PostMapping("/addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = eduTeacherService.save(eduTeacher);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @ApiOperation("根据id查询一位教师的信息")
    @GetMapping("/getId/{id}")
    public R getTeacher(@PathVariable String id) {
        EduTeacher teacher = eduTeacherService.getById(id);
        return R.ok().data("teacher", teacher);
    }

    @ApiOperation("更新一位教师的信息")
    @PostMapping("/update")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @ApiOperation("根据id更新一位教师的信息")
    @PutMapping("/updateById/{id}")
    public R updateTeacherById(@PathVariable String id,
                               @RequestBody EduTeacher eduTeacher) {
        eduTeacher.setId(id);
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

}

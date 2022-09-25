package com.ffideal.servicebase;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: ffideal
 * @CreateTime: 2022-08-14  17:02
 * @Description: TODO
 * @Version: 1.0
 */

@Component
public class EduMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 属性名
        this.setFieldValByName("gmtCreate",new Date(),metaObject);//metaObject元数据
        this.setFieldValByName("gmtModified",new Date(),metaObject);
        this.setFieldValByName("isDeleted",0,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }
}

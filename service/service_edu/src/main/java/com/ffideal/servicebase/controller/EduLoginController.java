package com.ffideal.servicebase.controller;

import com.ffideal.servicebase.commonutils.R;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ffideal
 * @CreateTime: 2022-09-21  15:32
 * @Description: 实现登录接口
 * @Version: 1.0
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin    // 解决跨域
public class EduLoginController {
    // login 登录
    @PostMapping("/login")
    public R login() {

        return R.ok().data("token","admin");
    }

    // info
    @GetMapping("/info")
    public R info() {
        return R.ok().data("roles","[admin]")
                .data("name","admin")
                .data("avatar","https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/10/30/65423f14-49a9-4092-baf5-6d0ef9686a85.png");
    }

}

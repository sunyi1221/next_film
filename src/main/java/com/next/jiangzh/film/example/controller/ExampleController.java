package com.next.jiangzh.film.example.controller;

import com.next.jiangzh.film.dao.entity.NextUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：测试controller
 * 类描述：测试controller
 * <p>
 * 创建人： Sunyi
 * 创建时间：2020/9/22 23:50
 *
 * @author Sunyi
 * @date 2020/9/22 23:50
 * @updateRemark 修改备注：测试controller
 */

@RestController
@RequestMapping(value = "/v1/example/")
@Api("ExampleController相关的api")
@Slf4j
public class ExampleController {

    @ApiOperation(value = "测试SwaggerValue", notes = "测试SwaggerNotes")
    @ApiImplicitParam(name = "str",
            value = "入参str", paramType = "query", required = true, dataType = "string")
    @RequestMapping(value = "test")
    public String test(String str) {
        NextUser nextUser = NextUser.builder().userName("sunyi").userPwd("123456").build();
        System.out.println(nextUser);
        return "test=" + str;
    }
}

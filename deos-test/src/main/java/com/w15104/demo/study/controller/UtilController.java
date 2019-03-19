package com.w15104.demo.study.controller;

import com.w15104.demo.study.basic.result.Result;
import com.w15104.demo.study.basic.util.IPUtils;
import com.w15104.demo.study.basic.util.PKUtil;
import com.w15104.demo.study.basic.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/*
 *
 * @Description 基础功能控制器
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@Api(tags="basic")
@RestController
@RequestMapping("/v1/util")
public class UtilController {

    /**
     * 获取所有产品信息
     * @return Result<String>
     */
    @ApiOperation(value = "获得UUID", httpMethod = "GET")
    @RequestMapping(value = "/get-uuid")
    @ResponseBody
    public Result<String> getUUID() {
        return ResultUtil.ok(PKUtil.getUUID());
    }

    /**
     * 探针测试接口
     * @return Result<String>
     */
    @ApiOperation(value = "用于探针检测", httpMethod = "GET")
    @RequestMapping(value = "/life")
    @ResponseBody
    public Result<String> isAlive() {
        return ResultUtil.ok("I am still alive!");
    }


    /**
     * 获取访问者IP
     * @return Result<String>
     */
    @ApiOperation(value = "用于获取远程访问者IP", httpMethod = "GET")
    @RequestMapping(value = "/host")
    @ResponseBody
    public Result<String> getRemoteIP(HttpServletRequest request) {
        return ResultUtil.ok(IPUtils.getIpAddr(request));
    }

}

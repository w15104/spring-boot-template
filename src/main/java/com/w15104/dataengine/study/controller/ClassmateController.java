package com.w15104.dataengine.study.controller;

import com.w15104.dataengine.study.basic.config.Result;
import com.w15104.dataengine.study.basic.util.ResultUtil;
import com.w15104.dataengine.study.entity.Classmate;
import com.w15104.dataengine.study.service.IClassmateService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/*
 *
 * @description 班级控制器
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@RestController
@RequestMapping("classmate")
public class ClassmateController {

    //获取班级服务类
    @Resource
    private IClassmateService classmateService;

    /**
     * 根据班級ID查找班級信息  http://localhost:8181/wfh/classmate/get/1
     * @param id 班級ID
     * @return List<Classmate> 班級信息列表
     */
    @RequestMapping(value = "/get/{id}")
    @ResponseBody
    public Result<List<Classmate>> findClassByID(@PathVariable String id){
        //返回访问值
        return ResultUtil.ok(classmateService.findClassByID(id));
    }

}

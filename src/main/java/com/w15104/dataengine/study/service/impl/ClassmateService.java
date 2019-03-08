package com.w15104.dataengine.study.service.impl;

import com.w15104.dataengine.study.mapper.ClassmateMapper;
import com.w15104.dataengine.study.pojo.Classmate;
import com.w15104.dataengine.study.service.IClassmateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 *
 * @description 班级服务
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@Service
public class ClassmateService implements IClassmateService {

    @Resource
    private ClassmateMapper classmateMapper;


    /**
     *  Description: 根据ID查找班级信息
     * @param id 班级ID
     * @return  List<Classmate>
     */
    public  List<Classmate> findClassByID(String id){
       return classmateMapper.findClassByID(id);
    }
}

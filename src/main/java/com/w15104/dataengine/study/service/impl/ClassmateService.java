package com.w15104.dataengine.study.service.impl;

import com.w15104.dataengine.study.basic.CommonException;
import com.w15104.dataengine.study.basic.ErrorCode;
import com.w15104.dataengine.study.mapper.ClassmateMapper;
import com.w15104.dataengine.study.entity.Classmate;
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
     *  根据ID查找班级信息
     * @param id 班级ID
     * @return  List<Classmate>
     */
    public  List<Classmate> findClassByID(String id)throws CommonException{
        try {
            return classmateMapper.findClassByID(id);
        }catch (Exception e){
             throw new CommonException(ErrorCode.E_00003, e);
        }

    }
}

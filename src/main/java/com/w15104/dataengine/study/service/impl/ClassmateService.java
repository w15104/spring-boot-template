package com.w15104.dataengine.study.service.impl;

import com.w15104.dataengine.study.basic.exception.CommonException;
import com.w15104.dataengine.study.basic.exception.ErrorCode;
import com.w15104.dataengine.study.mapper.ClassmateMapper;
import com.w15104.dataengine.study.entity.Classmate;
import com.w15104.dataengine.study.service.IClassmateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/*
 *
 * @Description 班级服务
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@Service
@Slf4j
public class ClassmateService implements IClassmateService {

    /**
     * 获取ClassmateMapper
     */
    @Resource
    private ClassmateMapper classmateMapper;

    /**
     *  根据ID查找班级信息
     * @param id 班级ID
     * @return  List<Classmate>
     */
    public  List<Classmate> findClassByID(String id) {
        try {
            return classmateMapper.findClassByID(id);
         }catch (Exception e){
             throw new CommonException(ErrorCode.E_00003, e);
        }
    }
}

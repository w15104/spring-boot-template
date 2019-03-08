package com.w15104.dataengine.study.service;

import com.w15104.dataengine.study.entity.Classmate;

import java.util.List;

/*
 *
 * @description 班级服务接口
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public interface IClassmateService {

    List<Classmate> findClassByID(String id);
}

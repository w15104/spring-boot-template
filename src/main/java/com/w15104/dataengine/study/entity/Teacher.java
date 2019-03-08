package com.w15104.dataengine.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 *
 * @description 教师实体类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Teacher {

    /**
     * 班级ID
     */
    private String classId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 描述
     */
    private String description;

    /**
     * 性别
     */
    private String sex;

    /**
     * 家庭
     */
    private String family;


}

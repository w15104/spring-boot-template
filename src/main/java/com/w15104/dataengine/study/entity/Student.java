package com.w15104.dataengine.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 *
 * @description 学生实体类
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
public class Student {

    /**
     * 班级ID
     */
    private String classId;

    /**
     * 学生姓名
     */
    private String studentName;

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

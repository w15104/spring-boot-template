package com.w15104.dataengine.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/*
 *
 * @description 班级实体类
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
public class Classmate {

    /**
     * 班级ID
     */
    private String classId;

    /**
     * 教师数量
     */
    private String teacherNum;

    /**
     * 学生数量
     */
    private String studentNum;


    /**
     * 班级位置
     */
    private String poision;

    /**
     * 班级描述
     */
    private String description;

    /**
     * 学生列表
     */
    private List<Student> studentList;

    /**
     * 教师列表
     */
    private List<Teacher> teacherList;


}

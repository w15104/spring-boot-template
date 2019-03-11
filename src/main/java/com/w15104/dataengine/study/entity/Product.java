package com.w15104.dataengine.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/*
 *
 * @description 产品实体类
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
public class Product {

    /**
     * ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String pname;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 类型
     */
    private String type;

    /**
     * 创建时间
     * DatetimeFormat是将String转换成Date，一般前台给后台传值时用
     * JsonFormat(pattern="yyyy-MM-dd")  将Date转换成String  一般后台传值给前台时.
     * JsonFormat会让时间以0区时间显示。如果直接使用会少了8小时（我所在的是北京时区）,  需添加 ：timezone = "GMT+8",
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy年MM月dd日 HH:mm:ss")
    private Date createDate;

}

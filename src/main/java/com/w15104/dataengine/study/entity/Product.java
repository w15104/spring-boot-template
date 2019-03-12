package com.w15104.dataengine.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel
@Data
@EqualsAndHashCode(callSuper=false)
public class Product {

    /**
     * ID
     */
	@ApiModelProperty(value = "项目id，长度20", example = "123456", required = true)
    private Integer id;

    /**
     * 名称
     */
	@ApiModelProperty(value = "项目名称，长度20", example = "deos", required = true)
    private String pname;

    /**
     * 价格
     */
	@ApiModelProperty(value = "价格", example = "15.6", required = true)
    private BigDecimal price;

    /**
     * 数量
     */
	@ApiModelProperty(value = "数量，长度20", example = "123", required = true)
    private Integer num;

    /**
     * 类型
     */
	@ApiModelProperty(value = "类型", example = "1", required = true)
    private String type;

    /**
     * 创建时间
     * DatetimeFormat是将String转换成Date，一般前台给后台传值时用
     * JsonFormat(pattern="yyyy-MM-dd")  将Date转换成String  一般后台传值给前台时.
     * JsonFormat会让时间以0区时间显示。如果直接使用会少了8小时（我所在的是北京时区）,  需添加 ：timezone = "GMT+8",
     */
	@ApiModelProperty(hidden = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy年MM月dd日 HH:mm:ss")
    private Date createDate;

}

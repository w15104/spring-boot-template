package com.w15104.demo.study.mapper;

import com.w15104.demo.study.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *
 * @Description 产品Mapper
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public interface ProductMapper {

    /**
     * 更新或保存产品信息
     * @param product 产品信息
     * @return sql受影响的条数
     */
    int saveOrUpdate(Product product);

    /**
     * 更新或保存产品信息
     * @param product 产品信息
     * @return sql受影响的条数
     */
    void updateByID(Product product);

    /**
     * 根据ID删除产品
     * @param id 产品ID
     * @return sql受影响的条数
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 根据ID查找产品
     * @param id 产品ID
     * @return 查找的产品
     */
    Product getById(@Param("id") Integer id);

    /**
     * 查找所有的产品
     * @return 获取所有产品列表
     */
    List<Product> getAll();

}

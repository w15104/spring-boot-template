package com.w15104.dataengine.study.mapper;

import com.w15104.dataengine.study.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *
 * @description 产品Mapper
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public interface ProductMapper {

    int saveOrUpdate(Product product);

    int deleteById(@Param("id") Integer id);

    Product getById(@Param("id") Integer id);

    List<Product> getAll();
}

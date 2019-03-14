package com.w15104.dataengine.study.service;

import com.w15104.dataengine.study.basic.exception.CommonException;
import com.w15104.dataengine.study.entity.Product;

import java.util.List;

/*
 *
 * @Description 商品服务接口
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public interface IProductService {

    void add(Product product);

    void updateByID(Product product);

    void deleteById(Integer id);

    Product getById(Integer id);

    List<Product> getListWithPage(Integer pageNo, Integer pageSize);

}

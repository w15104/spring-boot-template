package com.w15104.dataengine.study.service;

import com.w15104.dataengine.study.basic.CommonException;
import com.w15104.dataengine.study.entity.Product;

import java.util.List;

/*
 *
 * @description 商品服务接口
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public interface IProductService {

    int add(Product product) throws CommonException;

    int deleteById(Integer id)throws CommonException;

    Product getById(Integer id);

    List<Product> getListWithPage(Integer pageNo, Integer pageSize) throws CommonException;
}

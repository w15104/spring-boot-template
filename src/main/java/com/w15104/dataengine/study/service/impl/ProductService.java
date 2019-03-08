package com.w15104.dataengine.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.w15104.dataengine.study.mapper.ProductMapper;
import com.w15104.dataengine.study.pojo.Product;
import com.w15104.dataengine.study.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 *
 * @description 商品业务服务类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@Service
public class ProductService implements IProductService {

    //获取商品mapper类
    @Resource
    private ProductMapper productMapper;


    /**
     * Description：添加商品信息
     * @param product 商品实体
     * @return int
     */
    public int add(Product product){
        return productMapper.saveOrUpdate(product);
    }

    /**
     * Description： 根据ID删除商品
     * @param id 商品ID
     * @return int
     */
    public int deleteById(Integer id){
        return productMapper.deleteById(id);
    }

    /**
     * Description: 根基ID查找商品
     * @param id 商品ID
     * @return Product
     */
    public Product getById(Integer id){
        return productMapper.getById(id);
    }

    /**
     * Description: 这个方法中用到了我们开头配置依赖的分页插件pagehelper,很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * @pageNum 开始页数
     * @pageSize 每页显示的数据条数
    */
    public List<Product> getListWithPage(Integer pageNo,Integer pageSize){

        //将参数传给这个方法就可以实现物理分页了，非常简单。
        if(pageNo!=null && pageSize!=null){
            PageHelper.startPage(pageNo, pageSize);
        }
        return productMapper.getAll();
    }
}

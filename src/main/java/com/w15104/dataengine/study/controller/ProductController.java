package com.w15104.dataengine.study.controller;

import com.github.pagehelper.PageInfo;
import com.w15104.dataengine.study.basic.config.Result;
import com.w15104.dataengine.study.basic.exception.CommonException;
import com.w15104.dataengine.study.basic.util.ResultUtil;
import com.w15104.dataengine.study.entity.Product;
import com.w15104.dataengine.study.service.IProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/*
 *
 * @description 产品控制器
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@RestController
@RequestMapping("product")
public class ProductController {

    //获取产品服务
    @Resource
    private IProductService productService;

    /**
     * 分页查询产品信息 http://localhost:8181/wfh/product/getPage
     * @param pageNo: 查询第几页
     * @param pageSize 每页数量
     * @return PageInfo 分页信息
     */
    @RequestMapping(value = "/getPage/{pageNo}/{pageSize}}")
    @ResponseBody
    public Result<PageInfo> getPage(@PathVariable Integer pageNo, @PathVariable Integer pageSize)throws CommonException{
        List<Product> products = productService.getListWithPage(pageNo,pageSize);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return ResultUtil.ok(pageInfo);
    }

    /**
     * 获取所有产品信息
     * @return List<Product>
     */
    @RequestMapping(value = "/getAll")
    @ResponseBody
    public Result<List<Product>> getAll() throws CommonException{
        return ResultUtil.ok(productService.getListWithPage(null,null));
    }

    /**
     * 添加商品
     * @param product 产品信息
     * @return String
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Result<String> addProduct(Product product)throws CommonException{
        productService.add(product);
        return ResultUtil.ok();
    }

    /**
     *:删除商品
     * @param id 产品ID
     * @return String
     */
    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public Result<String> detete(@PathVariable  Integer id) throws CommonException{
        productService.deleteById(id);
        return ResultUtil.ok();
    }

    /**
     *:删除商品
     * @param id 产品ID
     * @return String
     */
    @RequestMapping(value = "/get/{id}")
    @ResponseBody
    public Result<Product> get(@PathVariable  Integer id) throws CommonException{
        return ResultUtil.ok(productService.getById(id));
    }
}

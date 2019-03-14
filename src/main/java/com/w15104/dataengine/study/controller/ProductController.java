package com.w15104.dataengine.study.controller;

import com.github.pagehelper.PageInfo;
import com.w15104.dataengine.study.basic.config.Result;
import com.w15104.dataengine.study.basic.exception.CommonException;
import com.w15104.dataengine.study.basic.util.ResultUtil;
import com.w15104.dataengine.study.entity.Product;
import com.w15104.dataengine.study.service.IProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;

/*
 *
 * @Description 产品控制器
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@Api(tags="product")
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    //获取产品服务
    @Resource
    @Autowired
    private IProductService productService;

    /**
     * 分页查询产品信息 http://localhost:8181/wfh/product/getPage
     * @param pageNo: 查询第几页
     * @param pageSize 每页数量
     * @return PageInfo 分页信息
     */
    @ApiOperation(value = "根据页码和单页数量查询", httpMethod = "GET")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNo", value = "查询第几页", required = true),
        @ApiImplicitParam(name = "pageSize", value = "分页长度", required = true)
    })
    @RequestMapping(value = "/get-page/{pageNo}/{pageSize}", headers = "Content-Type=application/json")
    @ResponseBody
    public Result<PageInfo> getPage(@PathVariable Integer pageNo, @PathVariable Integer pageSize)throws CommonException {
        List<Product> products = productService.getListWithPage(pageNo,pageSize);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return ResultUtil.ok(pageInfo);
    }

    /**
     * 获取所有产品信息
     * @return List<Product>
     */
    @ApiOperation(value = "获得所有的商品信息", httpMethod = "GET")
    @RequestMapping(value = "/get-all")
    @ResponseBody
    public Result<List<Product>> getAll() throws CommonException {
        return ResultUtil.ok(productService.getListWithPage(null,null));
    }

    /**
     * 添加商品
     * @param product 产品信息
     * @return String
     */
    @ApiOperation(value = "添加商品信息", httpMethod = "POST")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> addProduct(@RequestBody Product product)throws CommonException {
        productService.add(product);
        return ResultUtil.ok();
    }

    /**
     * 添加商品
     * @param product 修改产品信息
     * @return String
     */
    @ApiOperation(value = "修改商品信息", httpMethod = "PUT")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result<String> updateProduct(@RequestBody  Product product)throws CommonException {

        productService.updateByID(product);
        return ResultUtil.ok();
    }

    /**
     *:删除商品
     * @param id 产品ID
     * @return String
     */
    @ApiOperation(value = "删除商品信息", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "商品id", required = true)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result<String> detete(@PathVariable  Integer id) throws CommonException {
        productService.deleteById(id);
        return ResultUtil.ok();
    }

    /**
     *:根据ID获得信息
     * @param id 产品ID
     * @return String
     */
    @ApiOperation(value = "根据ID获得信息", httpMethod = "GET")
    @RequestMapping(value = "/get/{id}")
    @ResponseBody
    public Result<Product> get(@PathVariable  Integer id) throws CommonException {
        return ResultUtil.ok(productService.getById(id));
    }

}

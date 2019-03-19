package com.w15104.demo.study.service.impl;

import com.w15104.demo.study.service.IDistributedService;

/*
*
* @Description 规范服务之间的调度流程
*
* @author y15649
* @data: 2019-3-19
*
* @modified by:
* @modified date:
* @modified no:
*/
public class DistributedService implements IDistributedService {

	/**
	 * 从服务A到服务B的业务控制
	 */
	@Override
	public void serviceAToServiceB(String args) {
		
		/**
		 * 1. 检查参数是否合法
		 * 2. 该操作流程是否需要对数据库进行增、删、改的操作（查询操作不做约束）
		 * 3. 如果两个服务操作的数据没有直接的关系则优先对serviceA进行操作，之后再对serviceB进行操作
		 *    优点：a. 如果serviceA操作失败，可直接返回，结束流程，如果成功则可以发起对serviceB的调用。
		 *            serviceB（成功/失败）返回到serviceA，失败的话serviceA进行回滚
		 *    如果先对serviceB进行操作，则当serviceA操作失败后，还要再次访问serviceB做回滚（更新表）操作。
		 *  
		 */

	}

}

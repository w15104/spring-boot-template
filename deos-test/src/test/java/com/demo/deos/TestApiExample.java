package com.demo.deos;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.w15104.demo.study.App;
import com.w15104.demo.study.basic.util.DateUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 接口测试
 * @author yqz
 */
@Slf4j
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class) // 指定SpringBoot启动类
public class TestApiExample {

	/*接口*/
	private static final String api = "/v1/classmate/get/1";
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testApi() throws Exception {
		log.info("test api");
		mockMvc.perform(get(api).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print())
		.andReturn();
	}
	
	@Test
	public void testDate() throws ParseException {
		System.out.println(DateUtil.getTime("2019-03-18 11:35:00"));
	}
	
}

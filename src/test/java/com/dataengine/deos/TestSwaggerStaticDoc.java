package com.dataengine.deos;

import static com.dataengine.deos.Constant.*;

import java.io.InputStream;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.w15104.dataengine.study.App;

import ch.qos.logback.core.status.Status;
import io.github.robwin.markup.builder.MarkupLanguage;
import io.github.robwin.swagger2markup.GroupBy;
import io.github.robwin.swagger2markup.Swagger2MarkupConverter;
import io.swagger.io.HttpClient;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@Slf4j
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TestSwaggerStaticDoc {

	/*服务的地址和端口http://localhost:8181*/
	private static String SERVICE_URL = "/wfh";
	
	private String snippetDir = "target/generated-snippets";
	private String outputDir = "target/asciidoc";
	@Autowired
	private MockMvc mockMvc;
	
	/*static {
		StreamTool.checkFile(OUTPUT_DIR);
	}
	*/
	@Test
	public void createMsgFile() throws Exception {
		log.info("create json file");
		mockMvc.perform(get(URL).accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andDo(Swagger2MarkupResultHandler.outputDirectory(outputDir).build())
			.andReturn();
		
		/*Swagger2MarkupConverter.from(outputDir + "/swagger.json")
			.withPathsGroupedBy(GroupBy.TAGS)
			.withMarkupLanguage(MarkupLanguage.ASCIIDOC)
			.withExamples(snippetDir)
			.build()
			.intoFolder(outputDir);*/
		log.info("OK!");
	}
	
	/**
	 * 获得json文件
	 * @throws Exception
	 */
	public void outputJson() throws Exception {
		String url = SERVICE_URL + URL;
		// 创建http请求
		HttpClient httpClient = new HttpClient(url);
	    // 发起请求，得到返回值
		InputStream putStream = httpClient.execute();
		// 将输入流转换成字节数
		byte[] data = StreamTool.read(putStream);
		// 生成文件json文件
		StreamTool.saveDataToFile(data, FILE_PATH);
	}
	
	public void createJson() throws Exception {
		
		mockMvc.perform(get(URL).accept(MediaType.APPLICATION_JSON))
		.andDo(Swagger2MarkupResultHandler.outputDirectory(FILE_PATH).build())
		.andExpect(status().isOk())
		.andReturn();
				
	}
}

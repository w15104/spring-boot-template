package org.swagger.doc.util;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.swagger.doc.util.StreamTool;

import io.github.robwin.markup.builder.MarkupLanguage;
import io.github.robwin.swagger2markup.GroupBy;
import io.github.robwin.swagger2markup.Swagger2MarkupConverter;
import io.swagger.io.HttpClient;
import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.swagger.doc.util.Constant.*;

import java.io.InputStream;

@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class TestSwaggerStaticDoc {

	/* 服务的地址和端口http://localhost:8181 */
	private static String SERVICE_URL = "http://localhost:8181/wfh";

	private String snippetDir = "target/generated-snippets";
	private String outputDir = "target/asciidoc";

	static {
		StreamTool.checkFile(OUTPUT_DIR);
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void createMsgFile() throws Exception {
		/*
		 * mockMvc.perform(get(SERVICE_URL +
		 * URL).accept(MediaType.APPLICATION_JSON)) .andExpect(status().isOk())
		 * .andDo(Swagger2MarkupResultHandler.outputDirectory(FILE_PATH).build()
		 * ) .andReturn();
		 */
		outputJson();
		Swagger2MarkupConverter.from(outputDir + "/swagger.json")
				.withPathsGroupedBy(GroupBy.TAGS)
				.withMarkupLanguage(MarkupLanguage.ASCIIDOC)
				.withExamples(snippetDir).build()
				.intoFolder(outputDir);
	}

	/**
	 * 获得json文件
	 * 
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

}

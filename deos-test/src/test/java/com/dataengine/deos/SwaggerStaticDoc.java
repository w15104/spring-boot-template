package com.dataengine.deos;

import static com.dataengine.deos.Constant.*;

import java.io.InputStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.robwin.markup.builder.MarkupLanguage;
import io.github.robwin.swagger2markup.GroupBy;
import io.github.robwin.swagger2markup.Swagger2MarkupConverter;
import io.swagger.io.HttpClient;
public class SwaggerStaticDoc {

	private static final Logger logger = LoggerFactory.getLogger(SwaggerStaticDoc.class);
	/*服务的地址和端口*/
	private static String SERVICE_URL = "http://localhost:8181/wfh";
	
	static {
		StreamTool.checkFile(OUTPUT_DIR);
	}
	
	@Test
	public void createMsgFile() throws Exception {
		logger.info("create json file");
		outputJson();
		Swagger2MarkupConverter.from(FILE_PATH)
			.withPathsGroupedBy(GroupBy.TAGS)
			.withMarkupLanguage(MarkupLanguage.ASCIIDOC)
			.withExamples(SNIPPET_DIR)
			.build()
			.intoFolder(OUTPUT_DIR);
		logger.info("OK!");
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
}

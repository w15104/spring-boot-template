package com.dataengine.deos;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamTool {

	/**
	 * 将输入流转换成字节数组
	 * @param inStream
	 * @return
	 * @throws Exception
	 */
	public static byte[] read(InputStream inStream) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		
		int len  = 0;
		
		while((len = inStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, len);
		}
		
	    inStream.close();
		return outputStream.toByteArray();
	}
	
	/**
	 * 将数据写入文件
	 * @param data
	 * @param filePath
	 * @throws IOException
	 */
	public static void saveDataToFile(byte[] data, String filePath) throws IOException {
		OutputStream os = null;
		os = new FileOutputStream(new File(filePath));
		
		os.write(data, 0, data.length);
		os.flush();
		os.close();
	}
	
	/**
	 * 检查文件是否存在
	 * @param filePath
	 */
	public static void checkFile(String filePath) {
		File file = new File(filePath);
		if(!file.exists()) {
			file.mkdir();
		}
	}
}

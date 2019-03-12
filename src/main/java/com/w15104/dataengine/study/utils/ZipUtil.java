package com.w15104.dataengine.study.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 解压，压缩工具类
 * 
 * @author c13691
 * @date: 2017年8月7日
 * @see: ZipUtil
 * @since:
 */
public class ZipUtil {
	private static Logger logger = LoggerFactory.getLogger(ZipUtil.class);

	/**
	 * Description：压缩方法
	 * 
	 * @param src
	 *            源文件
	 * @param dest
	 *            压缩目的文件
	 * @throws IOException
	 *             IO读写异常
	 */
	public static void zip(String src, String dest) throws IOException {
		ZipOutputStream out = null;
		try {
			File outFile = new File(dest);
			out = new ZipOutputStream(outFile);
			File fileOrDirectory = new File(src);

			if (fileOrDirectory.isFile()) {
				zipFileOrDirectory(out, fileOrDirectory, "");
			} else {
				File[] entries = fileOrDirectory.listFiles();
				for (int i = 0; i < entries.length; i++) {
					zipFileOrDirectory(out, entries[i], "");
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (out != null){
				try {
					out.close();
				} catch (IOException localIOException3) {
				}
			}				
		}
	}

	/**
	 * Description：递归压缩文件或目录
	 * 
	 * @param out             压缩输出流对象
	 * @param fileOrDirectory 要压缩的文件或目录对象
	 * @param curPath         当前压缩条目的路径，用于指定条目名称的前缀
	 * @throws IOException    读写异常
	 */
	private static void zipFileOrDirectory(ZipOutputStream out, File fileOrDirectory, String curPath)
			throws IOException {
		FileInputStream in = null;
		try {
			if (!fileOrDirectory.isDirectory()) {
				// 压缩文件
				byte[] buffer = new byte[BasicConstant.ZIP_BYTE_SIZE];
                int bytes_read;
				in = new FileInputStream(fileOrDirectory);

				ZipEntry entry = new ZipEntry(curPath + fileOrDirectory.getName());
				out.putNextEntry(entry);
				
				while ((bytes_read = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytes_read);
				}
				out.closeEntry();
			} else {
				//压缩目录
				File[] entries = fileOrDirectory.listFiles();
				for (int i = 0; i < entries.length; i++) {
					// 递归压缩，更新curPaths
					zipFileOrDirectory(out, entries[i], curPath + fileOrDirectory.getName() + "/");
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			if (in != null){
				try {
					in.close();
				} catch (IOException localIOException2) {
				}
			}				
		}
	}

	/**
	 * Description：                  解压缩方法
	 *  
	 * @param file         解压前文件
	 * @param outputDir    解压缩目录
	 * @throws IOException IO读写异常
	 */
	public static void unTarGz(File file, String outputDir) throws IOException {
		TarInputStream tarIn = null;
		try {
			tarIn = new TarInputStream(new GZIPInputStream(new BufferedInputStream(new FileInputStream(file))), 2048);

			FileUtil.createDirectory(outputDir, null);// 创建输出目录

			TarEntry entry = null;
			while ((entry = tarIn.getNextEntry()) != null) {
				if (entry.isDirectory()) {// 是目录
					entry.getName();
					FileUtil.createDirectory(outputDir, entry.getName());//创建空目录
				} else {// 是文件
					File tmpFile = new File(outputDir + "/" + entry.getName());
					FileUtil.createDirectory(tmpFile.getParent() + "/", null);//创建输出目录
					OutputStream out = null;
					try {
						out = new FileOutputStream(tmpFile);
						int length;

						byte[] b = new byte[BasicConstant.UNZIP_BYTE_SIZE];
					
						while ((length = tarIn.read(b)) != -1){
							out.write(b, 0, length);
						}
							
					} catch (IOException ex) {
						throw ex;
					} finally {
						if (out!=null){
							out.close();
						}
					}
				}
			}

			logger.info(file.getName() + "压缩包解压完成.");
		} catch (IOException ex) {
			logger.error(file.getName() + "解压归档文件出现异常");
			throw new IOException("解压归档文件出现异常", ex);
		} finally {
			if (tarIn != null) {
				tarIn.close();
			}
				
		}
	}
}
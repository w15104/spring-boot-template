package com.w15104.demo.study.basic.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
 *
 * @Description zip格式压缩、解压类
 *
 * @author m14081
 * @data: 2019-3-18
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public class ZipUtil {
    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(ZipUtil.class);

    /**
     * 压缩文件或目录
     * @param filePath 文件或目录
     * @throws IOException 异常
     */
    public static File zip(String filePath) throws IOException {
        File target = null;
        File source = new File(filePath);
        if (source.exists()) {
            String zipName = source.getName() + ".zip";
            target = new File(source.getParent(), zipName);
            if (target.exists()) {
                target.delete();
            }

            FileOutputStream fileOutputStream = null;
            ZipOutputStream zipOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(target);
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                addEntry("", source, zipOutputStream);
            } finally {
                zipOutputStream.close();
                fileOutputStream.close();
            }
        } else {
            logger.error(source.getAbsolutePath() + "文件不存在！");
        }

        return target;
    }

    /**
     * 递归方式添加文件到压缩包
     * @param base 目录
     * @param source 待压缩文件
     * @param zipOutputStream zip文件输出流
     * @throws IOException 异常
     */
    private static void addEntry(String base, File source, ZipOutputStream zipOutputStream) throws IOException {
        String entry = base + source.getName();
        if (source.isDirectory()) {
            for (File file : source.listFiles()) {
                addEntry(entry + "/", file, zipOutputStream);
            }
        } else {
            FileInputStream fileInputStream = null;
            BufferedInputStream bufferedInputStream = null;
            try {
                byte[] buffer = new byte[1024 * 10];
                fileInputStream = new FileInputStream(source);
                bufferedInputStream = new BufferedInputStream(fileInputStream, buffer.length);
                int read = 0;
                zipOutputStream.putNextEntry(new ZipEntry(entry));
                while ( (-1 != (read = bufferedInputStream.read(buffer, 0, buffer.length)))) {
                    zipOutputStream.write(buffer, 0, read);
                }
            } finally {
                bufferedInputStream.close();
                fileInputStream.close();
            }
        }
    }

    /**
     * 解压
     * @param filePath 待解压文件
     * @param targetPath 解压文件到目的目录下
     * @throws IOException 异常
     */
    public static void unzip(String filePath, String targetPath) throws IOException {
        File source = new File(filePath);
        if (source.exists()) {
            ZipInputStream zipInputStream = null;
            BufferedOutputStream bufferedOutputStream = null;
            try {
                zipInputStream = new ZipInputStream(new FileInputStream(source));
                ZipEntry entry = null;
                while (null != (entry = zipInputStream.getNextEntry())) {
                    if (!entry.isDirectory()) {
                        File target = new File(targetPath, entry.getName());
                        if (!target.getParentFile().exists()) {
                            target.getParentFile().mkdirs();
                        }

                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(target));
                        int read = 0;
                        byte[] buffer = new byte[1024 * 10];
                        while (-1 != (read = zipInputStream.read(buffer, 0, buffer.length))) {
                            bufferedOutputStream.write(buffer, 0, read);
                        }
                        bufferedOutputStream.flush();
                    }
                }
            } finally {
                zipInputStream.closeEntry();
                zipInputStream.close();
                bufferedOutputStream.close();
            }
        }
    }
}

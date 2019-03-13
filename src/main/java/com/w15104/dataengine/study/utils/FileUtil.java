package com.w15104.dataengine.study.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.w15104.dataengine.study.basic.exception.CommonException;
import com.w15104.dataengine.study.basic.exception.ErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;



/*
 *
 * @Description  文件工具类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public class FileUtil extends FileUtils {

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 功能描述：创建文件夹
     * @param filePath 文件目录
     */
    public static void createDirectory(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            boolean result = file.mkdirs();
            if(!result){
                logger.error("create dir error");
            }
        }
    }

    /**
     * 文件下载
     * @param response HttpServletResponse
     * @param path 文件路径
     * @throws CommonException 异常
     */
    public static void downloadFile(HttpServletResponse response, String path) throws CommonException {
        InputStream fis = null;
        OutputStream toClient = null;
        try {
            File file = new File(path);
            fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len;
            String fileName = getPathName(path);
            //文件名为空时候扔异常
            if (StringUtils.isNotEmpty(fileName)) {
                response.addHeader("Content-Disposition", "attachment;filename=\"" + new String(fileName.getBytes(StandardCharsets.UTF_8), "ISO8859-1") + "\"");
                response.setContentType("application/octet-stream");
                toClient = new BufferedOutputStream(response.getOutputStream());
                while ((len = fis.read(buffer)) != -1) {
                    toClient.write(buffer, 0, len);
                }
                toClient.flush();
            } else {
                throw new CommonException(ErrorCode.E_00011);
            }
        } catch (IOException e) {
            logger.info("下载文件{}异常", path);
            throw new CommonException(ErrorCode.E_00011, e);
        } finally {
            inputStreamClose(fis);
            outputStreamClose(toClient);
        }
    }


    /**
     * 文件下载
     * @param response HttpServletResponse
     * @param path 文件路径
     * @param fileName 文件名
     * @throws CommonException 异常
     */
    public static void downloadFileByFileName(HttpServletResponse response, String path, String fileName) throws CommonException {
        InputStream fis = null;
        OutputStream toClient = null;
        try {
            File file = new File(path);
            fis = new FileInputStream(file);
            byte[] buffer = new byte['Ѐ'];
            int len;
            response.addHeader("Content-Disposition", "attachment;filename=\"" + new String(fileName.getBytes(StandardCharsets.UTF_8), "ISO8859-1") + "\"");
            response.setContentType("application/octet-stream");
            toClient = new BufferedOutputStream(response.getOutputStream());
            while ((len = fis.read(buffer)) != -1) {
                toClient.write(buffer, 0, len);
            }
            toClient.flush();
        } catch (IOException e) {
            logger.info("下载文件{}异常", path);
            throw new CommonException(ErrorCode.E_00011, e);
        } finally {
            inputStreamClose(fis);
            outputStreamClose(toClient);
        }
    }

    /**
     * 关闭输入流
     * @param inputStream 输入流
     */
    private static void inputStreamClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                logger.info("文件输入流关闭异常");
            }
        }
    }

    /**
     * 功能描述：关闭输出流
     * @param outputStream 输出流
     */
    private static void outputStreamClose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                logger.info("文件输出流关闭异常");
            }
        }
    }

    /**
     * 获取指定目录下包含指定type字段的文件
      * @param path 指定目录
     * @param type 包含字段
     * @return Lisy集合
     */
    public static List<String> getListFiles(String path, String type) throws Exception {
        File directory = new File(path);
        List<String> files = new ArrayList<>();
        if (directory.isFile()) {
            if (directory.getName().contains(type)) {
                files.add(directory.getPath());
                return files;
            }
        } else if (directory.isDirectory()) {
            File[] fileArr = directory.listFiles();
            if (null !=fileArr){
                for (File fileOne : fileArr) {
                    files.addAll(getListFiles(fileOne.getPath(), type));
                }
            }
        }
        return files;
    }

    /**
     * 获取指定目录下包含指定名称的文件
     * @param path 指定目录
     * @param type 指定名称
     * @return Lisy集合
     */
    public static List<String> getListFilesByName(String path, String type) {
        File directory = new File(path);
        List<String> files = new ArrayList<>();
        if (directory.isFile()) {
            if (directory.getName().equals(type)) {
                files.add(directory.getPath());
                return files;
            }
        } else if (directory.isDirectory()) {
            File[] fileArr = directory.listFiles();
            if(null != fileArr){
                for (File fileOne : fileArr) {
                    files.addAll(getListFilesByName(fileOne.getPath(), type));
                }
            }
        }
        return files;
    }

    /**
     * 获取父路径
     * @param path 路径
     * @return String
     */
    public static String getParentPath(String path) {
        if (path == null) {
            return null;
        }
        File file = new File(path);
        return file.getParent();
    }


    /**
     * 根据路径得到文件名
     * @param path 文件路径
     * @return String 文件名
     */
    public static String getPathName(String path) {
        if (path == null) {
            return null;
        }
        File file = new File(path);
        return file.getName();
    }

    /**
     * 字符串写入文件
     * @param file 文件
     * @param str 字符串
     * @throws CommonException CommonException
     */
    public static void writeToFile(File file, String str) throws CommonException {
        try {
            writeStringToFile(file, str, Charset.forName("UTF-8"));
        } catch (Exception e) {
            logger.error("文件写入失败");
            throw new CommonException(ErrorCode.E_00012, e);
        }
    }

    /**
     * 获取文件扩展名
     * @param filename 文件名
     * @return String 扩展名
     */
    public static String getExtension(String filename) {
        if (filename == null) {
            return null;
        }
        int index = filename.lastIndexOf('.');
        if (index == -1) {
            return "";
        }
        return filename.substring(index + 1);
    }

    /**
     * 递归删除文件夹下所有文件
     * @param path 文件夹路径
     */
    public static void deleteDirectory(String path) {
        try {
            FileUtils.deleteDirectory(new File(path));
        } catch (IOException e) {
            logger.error("delete Directory failed", e);
        }
    }

    /**
     * 递归删除文件及文件夹下所有文件
     * @param path 文件路径
     */
    public static void deleteFile(String path) {
        try {
            FileUtils.forceDelete(new File(path));
        } catch (IOException e) {
            logger.error("delete file failed", e);
        }
    }

    /**
     * 复制src文件夹下指定文件名的文件到dest文件夹下
     * @param src 源目录
     * @param dest 目的目录
     * @param filenameLists 指定文件集合
     * @throws IOException 异常
     */
    public static void copyFileWithFilename(File src, File dest, List<String> filenameLists) throws IOException {
        String[] files;
        if (src.isDirectory()) {
            if (!dest.exists()) {
                boolean result = dest.mkdir();
                if (!result){
                    logger.error("create dest dir error");
                }
            }
            files = src.list();
            if(null != files){
                for (String file : files) {
                    File srcFile = new File(src, file);
                    File destFile = new File(dest, file);
                    //递归复制
                    copyFileWithFilename(srcFile, destFile, filenameLists);
                }
            }
        } else {
            for (String filename : filenameLists) {
                if (src.toString().contains(filename)) {
                    copyFile(src, dest);
                    logger.debug("copyFileWithFilename: {} COPY TO {}",  src, dest);
                }
            }
        }
    }

    /**
     * 在指定目录下按照文件名创建目录，并上传文件
     * @param path 目标上传路径
     * @throws IOException 异常
     */
    public static void upload(String path) throws IOException {
        HttpServletRequest request = RequestContextUtil.getRequest();

        if ((request instanceof MultipartHttpServletRequest)) {
            //将request转换为MultipartHttpServletRequest
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //获取multiRequest下所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            //变量multiRequest下文件并上传
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile((String)iter.next());
                if (!file.isEmpty()) {
                    //自定义路径
                    String filePath = StringUtils.joinWith(File.separator, new Object[] { path, file.getOriginalFilename() });
                    //上传文件
                    file.transferTo(new File(filePath));
                }
            }
        }
    }

}
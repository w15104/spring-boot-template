package com.w15104.dataengine.study.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    private static String downedfilename = null;

    /**
     * 功能描述：创建文件夹
     * @param outputDir 输出目录
     * @param subDir  父级目录
     */
/*    public static void createDirectory(String outputDir, String subDir) {
        File file = new File(outputDir);
        if (StringUtils.isNotEmpty(subDir)) {
            file = new File(outputDir + "/" + subDir);
        }
        if (!file.exists()) {
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
            file.mkdirs();
        }
    }*/

    /**
     * 功能描述：文件下载
     * @param response
     * @param path 文件路径
     * @param downloadName 下载名称
     * @param ext 下载后缀名
     * @throws IOException 
     */
    public static void downloadFile(HttpServletResponse response, String path, String downloadName, String ext) throws IOException {
        InputStream fis = null;
        OutputStream toClient = null;
        downedfilename = downloadName;
        try {
            File file = new File(path);
            fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len = 0;
            response.addHeader("Content-Disposition", "attachment;filename=\""
                    + new String(downloadName.getBytes("gb2312"), "ISO8859-1") + ext + "\"");
            response.setContentType("application/zip");
            toClient = new BufferedOutputStream(response.getOutputStream());
            while ((len = fis.read(buffer)) != -1) {
                toClient.write(buffer, 0, len);
            }
            toClient.flush();
        } catch (IOException e) {
            logger.info("下载文件" + downloadName + "异常");
            throw e;
        } finally {
            inputStreamClose(fis);
            outputStreamClose(toClient);
        }
    }

    /**
     * 功能描述：复制一个目录及其子目录、文件到另外一个目录
     * @param src 源目录
     * @param dest 目的目录
     * @throws IOException IO读写异常
     */
    public static void copyFolder(File src, File dest) throws IOException {
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
            }
            String[] files = src.list();
            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                //递归复制
                copyFolder(srcFile, destFile);
            }
        } else {
            copyFile(src, dest);
        }
        logger.info("copyFolder:" + src + "COPY TO " + dest);
    }

    /**
     * 功能描述：复制src文件夹指定文件名的文件到dest文件夹下
     * @param src 源目录
     * @param dest 目的目录
     * @param filenameLists 指定文件集合
     * @throws IOException IO读写异常
     */
    public static void copyFileWithFilename(File src, File dest, List<String> filenameLists) throws IOException {
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
            }
            String[] files = src.list();
            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                //递归复制
                copyFileWithFilename(srcFile, destFile, filenameLists);
            }
        } else {
            for (String filename : filenameLists){
                if (src.toString().contains(filename)) {  //文件名为filename才能选择复制拷贝，对于多余的配置文件不复制
                    copyFile(src, dest);
                   logger.info("copyFileWithFilename:" + src + "COPY TO " + dest);
                }
            }
        }
    }

    /**
     * 功能描述：conf配置文件夹处理
     * @param f 待处理的文件夹
     * @param deleteFiles 删除文件夹
     */
    public static void handleFile(File f, Set<String> deleteFiles) {
        if ((f.exists()) && (f.isDirectory())) {
            File[] files = f.listFiles();
            if (files != null) {
                for (File file : files) {
                    String fileName = file.getName().replace("-conf", "");
                    if (deleteFiles.contains(fileName)){
                        deleteAllFiles(file);
                    }
                    else {
                        handleFile(file, deleteFiles);
                    }
                }
            }
        }
    }

    /**
     * 功能描述：删除文件夹自身及其包含的所有文件
     * @param f 待处理的文件夹
     * @param deleteFiles 文件夹内特定的文件夹或文件
     */
    public static void deleteFile(File f, Set<String> deleteFiles) {
        if (f.exists()) {
            File[] files = f.listFiles();
            if (files != null) {
                for (File file : files) {
                    String fileName = file.getName();
                    if (deleteFiles.contains(fileName)) {
                        if (file.isDirectory()) {
                            deleteAllFiles(file);
                            file.delete();
                        } else if (file.isFile()) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    /**
     * 功能描述：递归删除文件夹(后端增量下载文件夹除外)
     * @param f 删除文件夹
     */
    public static void deleteAllFiles(File f) {
        if (f.exists()) {
            File[] files = f.listFiles();
            if (files != null) {
                for (File file : files) {                    
                	if (file.isDirectory()) {
	                    deleteAllFiles(file);
	                    file.delete();
	                } else if (file.isFile()) {
	                    file.delete();
	                }
                }
            }
        }
    }

    /**
     * 功能描述：拷贝文件
     * @param src 源文件
     * @param dest
     * @author w15104 2017年11月13日
     */
    private static void copyFile(File src, File dest) {
        if (src.isFile()) {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new FileInputStream(src);
                out = new FileOutputStream(dest);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0){
                    out.write(buffer, 0, length);
                }
            } catch (Exception e) {
            } finally {
                inputStreamClose(in);
                outputStreamClose(out);
            }
        }
    }

    /**
     * 功能描述：关闭输入流
     * @param inputStream 输入流
     */
    private static void inputStreamClose(InputStream inputStream) {
        if (inputStream != null)
        {
            try {
                inputStream.close();
            } catch (IOException e) {
                logger.info("文件输入流关闭异常");
                e.printStackTrace();
            }
        }
    }

    /**
     * 功能描述：关闭输出流
     * @param outputStream
     */
    private static void outputStreamClose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                logger.info("文件输出流关闭异常");
                e.printStackTrace();
            }
        }
    }

    /**
     * 功能描述：获取指定目录下的所有文件（不包括文件夹）
     * @param obj 指定目录
     * @return ArrayList 所有文件集合
     */
    public static ArrayList<String> getListFiles(Object obj) {
        File directory;
        if ((obj instanceof File)) {
        	 directory = (File) obj;
        } else {
            directory = new File(obj.toString());
        }
        ArrayList<String> files = new ArrayList<>();
        if (directory.isFile()) {
            if (directory.getName().indexOf("Brief") == -1 && directory.getName().indexOf("Pic") == -1
                    && directory.getName().indexOf("Keyword") == -1
                    && directory.getName().indexOf("information") == -1
                    && directory.getName().indexOf("sample") == -1) {
            	files.add(directory.getPath());
            }
            return files;
        }else if (directory.isDirectory()) {
            File[] fileArr = directory.listFiles();
            for (int i = 0; i < fileArr.length; i++) {
                File fileOne = fileArr[i];
                files.addAll(getListFiles(fileOne));
            }
        }
        return files;
    }

    /**
     * 功能描述：获取指定目录下包含指定type字段的文件
     * @param obj 指定目录
     * @param type 包含字段
     * @return ArrayList 筛选文件夹集合
     */
    public static ArrayList<String> getListFiles(Object obj, String type) {
        File directory;
        if ((obj instanceof File)) {
            directory = (File) obj;
        }
        else {
            directory = new File(obj.toString());
        }
        ArrayList<String> files = new ArrayList<>();
        if (directory.isFile()) {
            if (directory.getName().indexOf(type) != -1) {
                files.add(directory.getPath());
                return files;
            }
        } else if (directory.isDirectory()) {
            File[] fileArr = directory.listFiles();
            for (int i = 0; i < fileArr.length; i++) {
                File fileOne = fileArr[i];
                files.addAll(getListFiles(fileOne, type));
            }
        }
        return files;
    }

    /**
     * 功能描述：判断指定目录是否存在
     * @param dirPath 目录名称
     */
    public static void judeFileExists(String dirPath) {
        File dir = new File(dirPath);
        dir.mkdirs();
    }

    
    /**
     * 功能描述： 根据配置文件获取配置信息
     * @param filePath 配置文件相对路径
     * @param key 配置文件属性值
     * @return 配置文件指定属性信息
     */
    public static String getProperty(String filePath, String key) {
        Properties p = new Properties();
        String val = "";
        InputStream in = null;
        try {
            in = FileUtil.class.getResourceAsStream(filePath);
            p.load(in);
            if (p.containsKey(key)){
                val = p.getProperty(key);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (in != null){
                    in.close();
                }
            } catch (IOException e) {
                logger.error("关闭文件流出现问题:{}", e);
                e.printStackTrace();
            }
        }
        return val;
    }

    /**
     * 功能描述：返回最近一次下载的文件的名称用于记录日志
     * @return 返回下载文件名
     */
    public static String getDownloadFileName() {
        return downedfilename;
    }

    /**
     * 功能描述：得到path的父路径
     * @param path
     * @return 父路径
     */
    public static String getParentPath(String path) {
        if (path == null) {
            return null;
        }
        File file = new File(path);
        return file.getParent();
    }

    /**
     * 功能描述：根据路径得到名字
     * @param path
     * @return
     */
    public static String getPathName(String path) {
        if (path == null) {
            return null;
        }
        File file = new File(path);
        return file.getName();
    }

    /**
     * 功能描述：把字符串写入到文件
     * @param file
     * @param str
     */
/*    public static void writeToFile(File file, String str) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(file));) {
        	 pw.write(str);
             pw.flush(); 
        } catch (Exception e) {
            logger.error("文件写入失败{}", e);
            throw new BasicException(ErrorCode.E_000001, e);
        }
    }*/

    /**
     * 功能描述：在指定目录下按照文件名称创建目录，并上传文件
     * @param request
     * @param response
     * @param path
     * @author w15104 2017年11月13日
     */
/*    public static void upload(HttpServletRequest request, HttpServletResponse response, String path) {
    	//将当前上下文初始化给CommonsMultipartResolver即多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver( request.getSession().getServletContext());
       
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
        	//将request 变成 multiRequest
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest中所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            //遍历multiRequest 中所有文件并上传文件
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile((String) iter.next());
                if (!file.isEmpty()) {
                    String fpath = StringUtils.joinWith(File.separator, path, file.getOriginalFilename() );
                    try {
                    	//上传文件
                        file.transferTo(new File(fpath));
                    } catch (IOException e) {
                        logger.error("文件上传失败{}", e);
                        throw new BasicException(ErrorCode.E_000001, e, "IO处理异常" );
                    }
                }
            }
        }
    }*/
}
package com.w15104.dataengine.study.utils;

/**
 * @description 用于存放代码中出现的各种常量
 * @author w11122
 */
public interface BasicConstant {

    String ROLE_USER_STR = "ROLE_USER";    //ROLE_USER权限

    String ROLE_ADMIN_STR = "ROLE_ADMIN";   //ROLE_ADMIN权限

    Integer ROLE_USER = Integer.valueOf(1);  //ROLE_USER权限

    Integer ROLE_ADMIN = Integer.valueOf(100);  //ROLE_ADMIN权限

    Integer USER_STATUS_NORMAL = Integer.valueOf(1);  //账号正常状态

    Integer USER_STATUS_LOCK = Integer.valueOf(0);    //账号锁定状态

    Integer LOG_RESULT_SUCCESS = Integer.valueOf(0);  //操作结果成功

    Integer LOG_RESULT_FAILD = Integer.valueOf(-1);   //操作结果失败

    String UNDEFINE = "undefine";                     //未定义的值

    String API_VERSION_PREFIX = "^/api/v[0-9]+.*";
    

    /**
     * @description 统一标准日期格式
     */
    String STANDARD_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    String DOWNLAOD_DATE_FORMAT = "yyyyMMddHHmmss";

    /**
     * 操作级别定义
     */
    String SEVERITY_CRITICAL = "critical";

    String SEVERITY_ORDINARY = "ordinary";

    
    /**
     * 集群连接超时时间（毫秒）
     */
    Integer CLUSTER_TIMEOUT = 5000;

    Integer ZIP_BYTE_SIZE = Integer.valueOf(4096);

    Integer UNZIP_BYTE_SIZE = Integer.valueOf(2048);

    String APPLICATION_REQUEST_SPLIT = "&";  //应用构建参数分隔符

    String APPLICATION_ARGS_SPLIT = "=";  //应用构建get请求参数分隔符

    String ADE_DOWNLOAD_PREFIX = "ade-eclipse-";  //下载文件前缀名

    String ADE_DOWNLOAD_SUFFIX = ".zip";   //下载文件后缀名

    String ADE_LINUX_SUFFIX = ".tar.gz";   

    Integer DOWNLOAD_SPLIT_NUMBER = 1;  //get参数截取部分常量

    String APPLICATION_MODEL_NAME = "/developdemo";  //应用构建项目名称

    String APPLICATION_MODEL_CONF = "/src/main/resources";  //应用构建集群配置文件路径

    String APPLICATION_POM_NAME = "/developdemo/pom.xml";    //应用构建pom.xml文件

    String DATAENGINE_CONF_SUFFIX = "_CLIENT-configs.tar.gz";   //DataEngine 下载配置文件字段

    String LDAP_SEARCH_NAME = "ou=People,dc=h3c,dc=com";    //LADP 查询用户名

    String LDAP_FILTER = "(!(cn=admin))";

    String DATASET_INFORMATION = "information";

    String DATASET_SAMPLE = "sample";

    String CAS_SWITCH = "0";   //CAS开启开关,0表示开始

    String JENKINS_SWITCH = "0";  //Jenkins开关量，0表示开启

    String JENKINS_ADMIN_EMAIL = "admin@h3c.com";  //Jenkins默认邮箱名

    String KNOWLEDGE_KEYWORD_SPLIT = "|";  //知识库关键字分隔符

    String KNOELEDGE_PICTURE_PATH = "images/knowledge/";  //知识库图片存放路径

    String FILETYPE_PDF = "pdf";   

    String RESET_USERPASSWD = "admin@h3c";

    String SUCCESS = "success";  //操作成功

    String FAIL = "fail";  //操作失败

    String ERROR = "error";  //操作错误
}
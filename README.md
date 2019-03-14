# spring-boot-template
spring-boot模板工程。  
该工程根据Java代码编程规范，在项目代码层面定义出模板。包含项目包结构定义，pom文件规范，配置文件规范，常用框架的使用范例，接口返回值规范，日志规范，
数据库连接池规范，注释规范等。  
目的是为了提高开发效率，降低开发成本，较少沟通成本以及后期维护成本。使编程小伙伴更加专注业务逻辑的开发。  


# 开发环境
springboot-version： 1.5.8-RELEASE
jdk: 1.8

# 工程目录结构
#### /src/main/java  源码包结构
1. App.java 该类为项目的启动类，包含加载配置和启动的方法
2. Swagger2.java swagger的配置
3. basic 基础组件包
    1. aop 切面实现
    2. config 配置文件
    3. constants 常量
    4. exception 异常处理
    5. util 工具类存放包
4. Controller 该目录存放控制类，控制类的方法体尽可能的小，不需要在方法中写业务逻辑的实现
5. Entity层存放实体类，并与对应的数据库表做映射
6. mapper层存放操作数据库的类
7. service层存放业务实现的接口和impl（存放实现业务逻辑类）目录

#资源目录结构
#### /src/main/Resources目录
1. application.properties 用来控制配置文件的选取
2. application-dev.properties  开发中的配置文件
3. application-prod.properties  部署环境中使用的配置文件
4. sql-files 数据库脚本归档目录
5. sqlmap 数据库和实体类的关联的配置文件 
6. mybatis mybatis的配置文件
7. logback.xml logback配置文件
8. other01 …other02 代表根据业务需要添加存放资源的目录

#### /src/main/bin 脚本目录
#### /src/test/java 测试目录
#### docs 文档目录


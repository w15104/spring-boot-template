# spring-boot-template
spring-boot模板工程。
git config --global user.email "1434613751@qq.com"
git config --global user.name w15104
#环境信息
springboot-version： 1.5.8-RELEASE
jdk: 1.8

#工程目录结构
1.1	/src/main/Java目录
a.	App.java 该类为项目的启动类，包含加载配置和启动的方法
b.  Swagger2.java swagger的配置
c.  basic 基础组件包
       aop 切面实现
       config 配置文件
       constants 常量
       exception 异常处理
       util 工具类存放包
d.	Controller 该目录存放控制类，控制类的方法体尽可能的小，不需要在方法中写业务逻辑的实现
e.	Entity层存放实体类，并与对应的数据库表做映射
f.	mapper层存放操作数据库的类
g.	service层存放业务实现的接口和impl（存放实现业务逻辑类）目录

1.2	/src/main/Resources目录
a.	application.properties 用来控制配置文件的选取
b.	application-dev.properties  开发中的配置文件
c.	application-prod.properties  部署环境中使用的配置文件
d.	sql-files 数据库脚本归档目录
e.  sqlmap 数据库和实体类的关联的配置文件 
f.  mybatis mybatis的配置文件
g.  logback.xml logback配置文件
g.	other01 …other02 代表根据业务需要添加存放资源的目录
1.3	/src/main/bin 脚本目录
1.4 /src/test/java 测试目录
1.5 docs 文档目录


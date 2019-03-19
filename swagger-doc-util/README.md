# Swagger生成静态文档的操作手册
1. 将要导出静态文档的服务正常启动，测试http://ip:port/服务名/v2/api-docs，能够返回信息则正常
2. 更改TestSwaggerStaticDoc中"SERVICE_URL"的地址更改为：http://ip:port/服务名
3. 执行junit测试
4. 执行成功后，在target/asciidoc/html（pdf）下会生成html接口的静态文档
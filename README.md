# FlyCloud
FlyClould 微服务实战项目框架，在该框架中，包括了用 Spring Cloud 构建微服务的一系列基本组件和框架，对于后台服务框架的搭建有很大的参考价值，大家可以参考甚至稍加修改可以直接应用于自己的实际的项目开发中
csdn地址：[https://blog.csdn.net/geduo_83/article/details/87866018](https://blog.csdn.net/geduo_83/article/details/87866018)
欢迎点赞加星，评论打call、加群：810970432

在该框架中包括了用 Spring Cloud 构建微服务的一系列基本组件和框架，对于后台服务框架的搭建有很大的参考价值，大家可以参考甚至稍加修改可以直接应用于自己的实际的项目开发中。

### 开发环境：
在该框架中，包括了用 Spring Cloud 构建微服务的一系列基本组件和框架，运行所需要软件如下：
* 开发IDE：IDEA
https://www.jetbrains.com/idea/download/#section=windows
* 数据库：mysql5.7
https://dev.mysql.com/downloads/mysql/
* 组件通信rabbitmq
http://www.rabbitmq.com/download.html
* Erlang环境
http://www.erlang.org/downloads Erlang环境
http://www.cnerlang.com/resource/182.html
该项目没有采用Maven进行项目构建，Maven通过xml进行依赖管理，导致整个配置文件太过臃肿，另外灵活性也不是很强，所以我采用Gradle进行项目构建和依赖管理，在FlyTour项目中我们见证了Gradle的强大，通过简单的一些配置就可以轻松的实现组件化的功能。该项目共有11个Moudle工程。其中10个位微服务工程，这10个微服务工程构成了一个完整的微服务系统，微服务系统包含了8个基础服务，提供了一整套微服务治理功能，他们分别是配置中心moudle_config、注册中心moudle_eureka、认证授权中心moudle_uaa、Turbine聚合监控服务moudle_monitor、链路追踪服务moudle_zipken、聚合监控服务moudle_admin、路由网关服务moudle_gateway、日志服务moudle_log。另外还包含了两个资源服务：用户服务moudle_user和blog服务moudle_blog，另外还有一个common的Moudle,为资源服务提供一些一本的工具类。
<br>完整的项目目录如下：
<br>![](https://img-blog.csdnimg.cn/20190222112420472.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
### 工程架构图：
<br>![](https://img-blog.csdnimg.cn/20190222112451518.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
<br>下面对11个Moudle工程分别进行介绍:
* 1.注册中心：moudle_eureka
在这个系统中，所有的服务都向注册中心moudle_eureka进行服务注册。能方便的查看每个服务的服务状况、服务是否可用,以及每个服务都有哪些服务实例
工作流程：
<br>![](https://img-blog.csdnimg.cn/20190222130826167.png)
* 2.配置中心：moudle_config
配置中心所有服务的配置文件由 config-server 管理，特别说明为了简单起见本框架中配置数据都放在本地并没有从git仓库远程获取
架构图：
<br>![](https://img-blog.csdnimg.cn/20190222132525638.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
* 3.网关服务：moudle_gateway
网关服务使用的是 Zuul 组件， Zuul 组件可以实现智能路由、负载均衡的功能 gateway-service 作为 个边界服务，对外统一暴露 API 接口，其他的服务 API 接口只提供给内部服务调用，不提供给外界直接调用，这就很方便实现统鉴权、安全验证的功能
通过路由网关实现负载均衡：
<br>![](https://img-blog.csdnimg.cn/20190222134903810.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
* 4.链路追踪服务：moudle_zipkin
它可以查看每个请求在微服务系统中的链路关系
* 5.聚合监控服务：moudle_admin
提供了非常强大的服务监控功能，可以查看每个向注册中心注册服务的健康状态， 日志、注册时间等
* 6.Turbine聚合监控服务：moudle_monitor
它聚合了 moudle_user和moudle_blog的Hystrix Dashboard ，可以查看这两个服务熔断器的监控状况
* 7.认证授权服务：moudle_uaa
Spring Cloud 0Auth2 由这个服务统一授权并返回Token。其他的应用服务例如moudle_user和moudle_blog作为资源服务 API 接口资源受保护的，需要验证Token并鉴后才能访问，我采用的0Auth2+JWT安全认证，需要生成私钥用于加密，公钥用于解密
生成私钥命令：
```
keytool -genkeypair -alias fly-jwt -validity 36500 -keyalg RSA -dname "CN=jwt,OU=jwt,O=jwt,L=haidian,S=beijing,C=CH" -keypass fly123 -keystore fly-jwt.jks -storepass fly123
```
生成公钥命令：
```
keytool -list -rfc --keystore fly-jwt.jks | openssl x509 -inform pem -pubkey
```
JWT认证流程：
<br>![](https://img-blog.csdnimg.cn/20190222140807479.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
* 8.用户服务：moudle_user
作为资源服务，对外暴露用户的API接口资源
* 9.blog服务：moudle_blog
作为资源服务，对外暴露blog的API接口资源
* 10.日志服务：moudle_log
作为日志服务， moudle_user和moudle_blog服务通过RabbitMQ向moudle_log发送业务操作日志的消息，最后统一保存在数据库，由它统一持久化操作日志
日志服务架构图：
<br>![](https://img-blog.csdnimg.cn/20190222142641298.png)
### 功能演示：
依次启动 moudle_eureka, moudle_config,moudle_zipkin及其他的微服务，等整个微服务系统完全启动之后，在览器上访问 即：http://localhost:8761，即就是Eureka 可以查看服务注册的情况
![](https://img-blog.csdnimg.cn/20190222112508530.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
API 接口文档采用 Swagger2 框架生成在线文档， moudle_user 工程和 moudle_blog工程集成了Swagger2 ，集成Swagger2 只需要引入依赖，并做相关的配置，然后在具体的 Controller上写注解，就可以实现 Swagger2的在线文档功能在浏览器输入http://localhost:8762/swagger-ui.html 查看user服务的api文档
![](https://img-blog.csdnimg.cn/20190222112530157.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
在浏览器输入http://localhost:8763/swagger-ui.html 查看blog服务的api文档 
![](https://img-blog.csdnimg.cn/20190222112530157.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
![](https://img-blog.csdnimg.cn/201902221125490.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
 在浏览器上访问 http://localhost :9998 展示了 admin-service 登录界面，admin-service 作为 个综合监控的服务，需要对访问者进行身份认证才能访问它的主页，登录用户名为 dmin 密码为 123456
![](https://img-blog.csdnimg.cn/20190222112614615.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
这是登录成功后进入的首页面： 
![](https://img-blog.csdnimg.cn/20190222112628215.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
点击TURBINE,这是user服务和blog服务的熔断器监控页面
![](https://img-blog.csdnimg.cn/20190222112644214.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
在浏览器上访问 http://localhost :9411查看服务之间相互调用的链路追踪
![](https://img-blog.csdnimg.cn/20190222112657972.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
好了，截止到现在整个项目就全部介绍完了，本项目可以直接拿来应用，进行项目开发，本框架代码量较大，所以我就不贴源代码了
### 问题反馈
在使用中有任何问题，请在下方留言，或加入Android、Java开发技术交流群
QQ群：810970432
email：geduo_83@163.com
![](https://img-blog.csdnimg.cn/20190126213618911.png)
### 关于作者
```
var geduo_83 = {
    nickName  : "门心叼龙",
    site : "http://www.weibo.com/geduo83"
}
```
### License
```
Copyright (C)  menxindiaolong, FlyCloud Framework Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

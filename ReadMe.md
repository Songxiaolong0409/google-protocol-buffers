# Google Protocol Buffers

Google Protocol Buffer( 简称 Protobuf) 是 Google 公司内部的混合语言数据标准

## 壹. pom配置 os.detected.classifier

运行代码，并把结果在 `https://github.com/trustin/os-maven-plugin` 地址内找到
拼接成 `<os.detected.classifier>windows-x86_64</os.detected.classifier>` 写在pom 的properties 中
   
    System.out.println(System.getProperty("os.name"));
    System.out.println(System.getProperty("os.arch"));
    
常见值：
    
    windows-x86_64
    osx-x86_64
    
## 贰. 编写 .proto 文件 User.proto

## 叁. .proto 语法 `https://juejin.cn/post/6844903984914759693`

示例：

    syntax = "proto3"; //第一行说明使用的是proto3 的语法；若不指定该行 protocol buffer 编译器会认为是 proto2 。该行必须是文件的第一个非空或非注释行。
    
    package com.demo.protobuf.proto;//.proto文件包地址
    
    import "User.proto";//.proto文件名
    
    option java_outer_lassname = "UserVO"; 生成java文件名
    
    message User {
      string username = 1; //每个字段都有唯一的字段编号
      int32 sex = 2;
      string email = 3;
      bool enable = 4;
    }
    
    message UserResponse {...} //同时定义多个消息类型
    
与java数据类型对标（支持java、Notes、C++、Python、Go、C#、PHP、Ruby、Dart）

proto |  java 
----- |  ---
double  |   double
float  |   float
int32  |   int
int64  |   long
bool  |   boolean
string  |   String
bytes  |   ByteString

枚举类型

    message SearchRequest {
      string query = 1;
      int32 page_number = 2;
      int32 result_per_page = 3;
      enum Corpus {
        UNIVERSAL = 0;
        WEB = 1;
        IMAGES = 2;
        LOCAL = 3;
        NEWS = 4;
        PRODUCTS = 5;
        VIDEO = 6;
      }
      Corpus corpus = 4;
    }

## 肆. 注意事项

`proto`文件夹必须和`java`文件夹同目录，且设置为 `Sources Root`

方法：右键`proto`---`Mark Directory as` --- `Sources Root`

## 伍. 生成java 代码

运行 `Maven` 下的 `compile`，在`target/generated-sources/protobuf/java/`

## 陆. set Value 运行，打印byte[] 

Example: `ProtobufExample.java`

## 柒. web项目运行 

Example： `ProtobufHttpMessageConverterExample.java`

需要注入：

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }
    
## 扒. Client 调用

### 1. `RestTemplate` 方式

注入：
    
    @Bean
    RestTemplate restTemplate() {
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new ProtobufHttpMessageConverter());
        return rt;
    }

Example：`ClientRestTemplateExample.java`

### 2. `HttpURLConnection` 方式  

Example：`ClientHttpURLConnectionExample.java`  


# gRpc

gRpc是google开源的一个高性能、跨语言的rpc框架，基于HTTP2协议，基于protobuf 3.x

example Server:
    grpc-server-api: client 和server 公用 项目，proto 文件。
    grpc-server: server端
    gprc-client: client端

1. 编写 .proto 文件 User.proto

2. grpc-server-api pom.xml配置 ，一样要配置protobuf-maven-plugin

        <dependency>
            <groupId>com.google.protobuf</groupId>
            <artifactId>protobuf-java</artifactId>
            <version>${protobuf.version}</version>
        </dependency>
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-all</artifactId>
            <version>1.34.0</version>
        </dependency>
    
3. 运行 `Maven` 下的 `compile` 

4. 编写server方法 `GrpcServerExample.java` ,启动类里设置端口，并启动。

5. 编写client方法 `GrpcClientExample.java` ,`GprcClientApplicationTests.java` 测试。
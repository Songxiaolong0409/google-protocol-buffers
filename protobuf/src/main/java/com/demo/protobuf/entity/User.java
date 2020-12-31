package com.demo.protobuf.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    String username ; //用户名
    int sex ;      //性别
    String email;   //邮箱
    Boolean enable;   //是否可用
}

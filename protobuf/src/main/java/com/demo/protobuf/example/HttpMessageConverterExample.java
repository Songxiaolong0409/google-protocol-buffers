package com.demo.protobuf.example;

import com.demo.protobuf.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 普通的http 接口 例子
 */
@Slf4j
@RestController
public class HttpMessageConverterExample {

    @GetMapping("/getJson")
    @ResponseBody
    public User getJson(){
        User user=new User();
        user.setEmail("xiaolong.song@fih-foxconn.com");
        user.setEnable(true);
        user.setSex(1);
        user.setUsername("xiaolong.song");

        log.info(user.toString());

        return user;
    }

}

/**
 * Copyright @2019/3/13 Fih-foxconn All Rights Reserved
 */
package com.demo.protobuf;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author xiaolong.song
 * @Package com.fih.core.config
 * @Description:
 * @email loye.song@foxmail.com
 * @date 2019/3/13 11:10
 */
@Configuration
public class JacksonFormatConfigure {
    /**
     * spring boot responseBody返回Json LocalDateTime格式转换
     * <p>
     * 也可以在字段或者方法参数前加 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 注解
     */
    @Value("${spring.jackson.date-format}")
    private String pattern;

    @Getter
    @Value("${machineid:1}")
    private Integer machineid;

    @Bean
    public LocalDateSerializer localDateDeserializer() {
        return new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Bean
    public LocalDateTimeSerializer localDateTimeDeserializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {

        return builder -> builder.serializerByType(LocalDateTime.class, localDateTimeDeserializer())
                .serializerByType(LocalDate.class, localDateDeserializer());

    }
}
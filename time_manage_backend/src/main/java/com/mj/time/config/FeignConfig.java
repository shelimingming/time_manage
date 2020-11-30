package com.mj.time.config;

import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FeignConfig {
    //    @Bean
    //    Decoder feignDecoder() {
    //        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(new ObjectMapper());
    //
    //        List<MediaType> mediaTypeList = new ArrayList<>(16);
    //        mediaTypeList.addAll(jacksonConverter.getSupportedMediaTypes());
    //        // 增加新的类型支持
    //        mediaTypeList.add(MediaType.TEXT_PLAIN);
    //        jacksonConverter.setSupportedMediaTypes(mediaTypeList);
    //        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
    //        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    //    }
    //注入新的Decoder Feign将自动 替换
    // 解决微信返回参数为[text/plain] 无法转化为json
    @Bean
    public Decoder feignDecoder() {
        MessageConverter messageConverter = new MessageConverter();
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(messageConverter);
        return new SpringDecoder(objectFactory);
    }


}
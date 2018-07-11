/**
 * 
 */
package com.example.demo.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * @author 谢意
 *
 */
@Configuration
public class FastJsonConfiguration extends WebMvcConfigurerAdapter {
	
	public void configurationMessageConverters(List<HttpMessageConverter<?>> converters) {
		//调用父类配置
		super.configureMessageConverters(converters);
		//创建fastjson消息转换器
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		//创建配置类
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		//修改配置返回内容的过滤
		fastJsonConfig.setSerializerFeatures(
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteNullStringAsEmpty
		);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		//将fastjson添加到视图消息转换器列表内
		converters.add(fastConverter);
	}
}

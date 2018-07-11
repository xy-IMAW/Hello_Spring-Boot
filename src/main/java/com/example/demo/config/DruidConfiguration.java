package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 
 */

/**
 * Druid配置和过滤器配置
 * @author 谢意
 *
 */
@Configuration

public class DruidConfiguration {
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")//返回druid型的数据库连接，不然无法检测到SQL语句
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}
	@Bean
	public ServletRegistrationBean statViewServlet() {
		//创建servlet注册实体
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		//设置ip白名单
		//servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
		//设置IP黑名单
		//servletRegistrationBean.addInitParameter("deny", "");
		//设置控制台管理用户
		servletRegistrationBean.addInitParameter("loginUsername", "druid");
		servletRegistrationBean.addInitParameter("loginPassword", "123456");
		//是否可以重置数据
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		return servletRegistrationBean;
	}
	
	@Bean
	public FilterRegistrationBean statFilter() {
		//设置过滤器
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		//设置过滤器过滤路径
		filterRegistrationBean.addUrlPatterns("/*");
		//忽略过滤的形式
		filterRegistrationBean.addInitParameter("exclusionns", "*.js,*.gif,*.jpg,*.css,*.png,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}

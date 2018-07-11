/**
 * 
 */
package com.example.demo.listener;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author 谢意
 *服务启动时执行
 */
@Component
public class StartRunner implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("服务启动时执行："+new Date());
	}

}

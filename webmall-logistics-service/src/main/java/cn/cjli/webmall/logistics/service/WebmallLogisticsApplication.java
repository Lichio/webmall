package cn.cjli.webmall.logistics.service;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * webmall cn.cjli.webmall.logistics.service
 *
 * @author Lichaojie
 * @version 2019/5/21 19:33
 */
@EnableDubbo
@SpringBootApplication
public class WebmallLogisticsApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(WebmallLogisticsApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WebmallLogisticsApplication.class);
	}
}

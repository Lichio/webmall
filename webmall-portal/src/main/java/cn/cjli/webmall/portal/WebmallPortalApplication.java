package cn.cjli.webmall.portal;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class WebmallPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebmallPortalApplication.class, args);
	}

}

package cn.cjli.webmall.portal.config;

import cn.cjli.webmall.portal.component.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * webmall cn.cjli.webmall.portal.config
 *
 * @author Lichaojie
 * @version 2019/5/23 11:05
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Autowired
	private LoginInterceptor loginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
	}
}

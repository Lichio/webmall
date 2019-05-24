package cn.cjli.webmall.portal.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * webmall cn.cjli.webmall.portal.config
 *
 * @author Lichaojie
 * @version 2019/5/21 17:14
 */
@Configuration
public class RabbitMQConfig {
	@Bean
	public Queue notificationQueue() {
		return new Queue("notification");
	}
}

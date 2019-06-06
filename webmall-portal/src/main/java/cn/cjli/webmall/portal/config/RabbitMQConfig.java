package cn.cjli.webmall.portal.config;

import cn.cjli.webmall.portal.domain.QueueType;
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
	public Queue testNotify() {
		return new Queue("testNotify");
	}

	@Bean
	public Queue buyerNotify(){return new Queue(QueueType.BUYER_NOTIFY.getValue());}

	@Bean
	public Queue sellerNotify(){return new Queue(QueueType.SELLER_NOTIFY.getValue());}
}

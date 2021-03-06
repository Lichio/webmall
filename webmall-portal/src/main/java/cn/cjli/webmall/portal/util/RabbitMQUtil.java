package cn.cjli.webmall.portal.util;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * webmall cn.cjli.webmall.portal.util
 *
 * @author Lichaojie
 * @version 2019/5/21 17:29
 */
@Component
public class RabbitMQUtil {
	@Autowired
	private AmqpTemplate amqpTemplate;

	public void sendMessage(String queue, Object message){
		amqpTemplate.convertAndSend(queue,message);
	}
}

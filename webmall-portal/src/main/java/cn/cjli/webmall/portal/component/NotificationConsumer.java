package cn.cjli.webmall.portal.component;

import cn.cjli.webmall.data.entity.TestEntity;
import cn.cjli.webmall.portal.vo.TestEntityVO;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * webmall cn.cjli.webmall.portal.service.consumer
 *
 * @author Lichaojie
 * @version 2019/5/21 17:35
 *
 * 异步处理通知请求
 */
@Component
public class NotificationConsumer {

	@RabbitListener(queues = "notification")
	@RabbitHandler
	public void process(@Payload TestEntityVO message){
		System.out.println(((TestEntityVO)message).getInfo());

	}
}

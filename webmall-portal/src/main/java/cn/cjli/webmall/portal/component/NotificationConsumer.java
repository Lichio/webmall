package cn.cjli.webmall.portal.component;

import cn.cjli.webmall.data.entity.Buyer;
import cn.cjli.webmall.data.entity.Seller;
import cn.cjli.webmall.portal.vo.TestEntityVO;
import cn.cjli.webmall.service.sms.SMService;
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


	@RabbitListener(queues = "testNotify")
	@RabbitHandler
	public void process(@Payload TestEntityVO message){
		System.out.println(message.getInfo());

	}

	@RabbitListener(queues = "buyerNotify")
	@RabbitHandler
	public void process(@Payload Buyer buyer){
		SMService.sendSmsNotification(buyer.getUsername(), buyer.getUsername());

	}

	@RabbitListener(queues = "sellerNotify")
	@RabbitHandler
	public void process(@Payload Seller seller){
		SMService.sendSmsNotification(seller.getUsername(), seller.getUsername());
	}
}

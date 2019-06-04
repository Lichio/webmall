package cn.cjli.webmall.portal.service;

import cn.cjli.webmall.data.entity.Order;
import cn.cjli.webmall.portal.vo.OrderShowVO;

import java.util.List;

/**
 * webmall cn.cjli.webmall.portal.service
 *
 * @author Lichaojie
 * @version 2019/6/4 10:35
 */
public interface OrderService {

	Order addOrder(long commodityId,
				   long buyerId,
				   int quantity,
				   String address,
				   double totalValue);

	List<OrderShowVO> showBuyerOrder(long buyerId);

	List<OrderShowVO> showSellerOrder(long sellerId);
}

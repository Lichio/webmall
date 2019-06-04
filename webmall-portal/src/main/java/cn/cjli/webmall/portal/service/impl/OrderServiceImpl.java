package cn.cjli.webmall.portal.service.impl;

import cn.cjli.webmall.data.co.OrderDetailCO;
import cn.cjli.webmall.data.entity.Commodity;
import cn.cjli.webmall.data.entity.Order;
import cn.cjli.webmall.data.repository.CommodityRepository;
import cn.cjli.webmall.data.repository.OrderRepository;
import cn.cjli.webmall.portal.service.OrderService;
import cn.cjli.webmall.portal.util.CodeGenerator;
import cn.cjli.webmall.portal.vo.OrderShowVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * webmall cn.cjli.webmall.portal.service.impl
 *
 * @author Lichaojie
 * @version 2019/6/4 10:38
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private CommodityRepository commodityRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order addOrder(long commodityId, long buyerId, int quantity, String address, double totalValue) {
		Commodity commodity = commodityRepository.getOne(commodityId);
		Order order = new Order();
		order.setCommodityId(commodityId);
		order.setBuyerId(buyerId);
		order.setQuantity(quantity);
		order.setAddress(address);
		order.setTotalValue(totalValue);
		order.setSellerId(commodity.getSellerId());
		order.setStatus((byte)1);
		order.setDeleted(false);
		order.setCreateTime(new Date());
		order.setOrderSn(CodeGenerator.orderSn(order.getCreateTime(),commodity.getCommodityId()));

		return orderRepository.save(order);
	}

	@Override
	public List<OrderShowVO> showBuyerOrder(long buyerId) {
		List<OrderDetailCO> dataCO = orderRepository.findOrdersDetailByBuyerId(buyerId);
		List<OrderShowVO> dataVO = new ArrayList<>();
		dataCO.forEach(e -> dataVO.add(OrderShowVO.cast(e)));

		return dataVO;
	}

	@Override
	public List<OrderShowVO> showSellerOrder(long sellerId) {
		List<OrderDetailCO> dataCO = orderRepository.findOrdersDetailBySellerId(sellerId);
		List<OrderShowVO> dataVO = new ArrayList<>();
		dataCO.forEach(e -> dataVO.add(OrderShowVO.cast(e)));

		return dataVO;
	}
}

package cn.cjli.webmall.portal.service.impl;

import cn.cjli.webmall.data.co.OrderDetailCO;
import cn.cjli.webmall.data.entity.Commodity;
import cn.cjli.webmall.data.entity.Logistics;
import cn.cjli.webmall.data.entity.Order;
import cn.cjli.webmall.data.repository.CommodityRepository;
import cn.cjli.webmall.data.repository.LogisticsRepository;
import cn.cjli.webmall.data.repository.OrderRepository;
import cn.cjli.webmall.portal.service.OrderService;
import cn.cjli.webmall.portal.util.CodeGenerator;
import cn.cjli.webmall.portal.vo.OrderShowVO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
	@Autowired
	private LogisticsRepository logisticsRepository;

	@Override
	@Transactional
	public Order addOrder(long commodityId, long buyerId, int quantity, String address, double totalValue) {
		Commodity commodity = commodityRepository.getOne(commodityId);
		if (commodity.getQuantity() < quantity){
			return null;
		}
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

		String orderSn = CodeGenerator.orderSn(order.getCreateTime(),commodity.getCommodityId());
		order.setOrderSn(orderSn);
		commodityRepository.updateQuantity(commodity.getCommodityId(),commodity.getQuantity() - quantity);

		Logistics logistics = new Logistics();
		logistics.setOrderSn(orderSn);
		logistics.setStatus((byte)((Math.random() * 10) % 5));
		logisticsRepository.save(logistics);

		return orderRepository.save(order);
	}

	@Override
	public Object showBuyerOrder(long buyerId, int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createTime");
		Page<OrderDetailCO> data = orderRepository.findOrdersDetailByBuyerId(pageable, buyerId);
		List<OrderDetailCO> dataCO = data.getContent();
		List<OrderShowVO> dataVO = new ArrayList<>();
		dataCO.forEach(e -> dataVO.add(OrderShowVO.cast(e)));

		JSONObject json = new JSONObject();
		json.put("content",dataVO);
		json.put("totalElements",data.getTotalElements());

		return json;
	}

	@Override
	public List<OrderShowVO> showSellerOrder(long sellerId) {
		List<OrderDetailCO> dataCO = orderRepository.findOrdersDetailBySellerId(sellerId);
		List<OrderShowVO> dataVO = new ArrayList<>();
		dataCO.forEach(e -> dataVO.add(OrderShowVO.cast(e)));

		return dataVO;
	}

	@Override
	public void deleteBuyerOrder(String orderSn) {
		orderRepository.logicallyDelete(orderSn);
	}

	@Override
	public OrderShowVO orderDetails(String orderSn) {
		OrderDetailCO co = orderRepository.getByOrderSn(orderSn);
		return OrderShowVO.cast(co);
	}
}

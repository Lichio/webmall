package cn.cjli.webmall.portal.vo;

import cn.cjli.webmall.data.co.OrderDetailCO;

import java.util.Date;

/**
 * webmall cn.cjli.webmall.portal.vo
 *
 * @author Lichaojie
 * @version 2019/6/4 12:03
 */
public class OrderShowVO extends OrderDetailCO {
	public OrderShowVO(String orderSn, long commodityId, String name, String picture, int quantity, double totalValue, Date createTime, byte status) {
		super(orderSn, commodityId, name, picture, quantity, totalValue, createTime, status);
	}

	public static OrderShowVO cast(OrderDetailCO co){
		return new OrderShowVO(co.getOrderSn(),
				co.getCommodityId(),
				co.getName(),
				co.getPicture(),
				co.getQuantity(),
				co.getTotalValue(),
				co.getCreateTime(),
				co.getStatus());
	}
}

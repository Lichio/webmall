package cn.cjli.webmall.portal.controller;

import cn.cjli.webmall.common.vo.CommonResult;
import cn.cjli.webmall.portal.ro.OrderAddRO;
import cn.cjli.webmall.portal.service.OrderService;
import cn.cjli.webmall.portal.vo.OrderShowVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * webmall cn.cjli.webmall.portal.controller
 *
 * @author Lichaojie
 * @version 2019/6/4 10:32
 */
@RestController
@CrossOrigin
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/v1.0/buyer/order", method = RequestMethod.POST)
	public CommonResult newOrder(@RequestBody OrderAddRO orderAddRO){
		orderService.addOrder(orderAddRO.getCommodityId(),
				orderAddRO.getBuyerId(),
				orderAddRO.getQuantity(),
				orderAddRO.getAddress(),
				orderAddRO.getTotalValue());
		return CommonResult.success();
	}

	@RequestMapping(value = "/v1.0/buyer/orders", method = RequestMethod.GET)
	public CommonResult<List<OrderShowVO>> showBuyerOrder(@RequestParam("buyerId") long buyerId){
		List<OrderShowVO> data = orderService.showBuyerOrder(buyerId);
		return CommonResult.success(data);
	}

	@RequestMapping(value = "/v1.0/seller/orders", method = RequestMethod.GET)
	public CommonResult<List<OrderShowVO>> showSellerOrder(@RequestParam("sellerId") long sellerId){
		List<OrderShowVO> data = orderService.showSellerOrder(sellerId);
		return CommonResult.success(data);
	}
}

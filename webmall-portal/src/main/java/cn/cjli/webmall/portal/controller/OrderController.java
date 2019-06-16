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
	public CommonResult<Object> showBuyerOrder(@RequestParam("buyerId") long buyerId,
														  @RequestParam("pageSize") int pageSize,
														  @RequestParam("pageNumber") int pageNumber){
		Object data = orderService.showBuyerOrder(buyerId, pageNumber, pageSize);
		return CommonResult.success(data);
	}

	@RequestMapping(value = "/v1.0/seller/orders", method = RequestMethod.GET)
	public CommonResult<List<OrderShowVO>> showSellerOrder(@RequestParam("sellerId") long sellerId){
		List<OrderShowVO> data = orderService.showSellerOrder(sellerId);
		return CommonResult.success(data);
	}

	@RequestMapping(value = "/v1.0/buyer/order", method = RequestMethod.DELETE)
	public CommonResult deleteBuyerOrder(@RequestParam("orderSn")String orderSn){
		orderService.deleteBuyerOrder(orderSn);
		return CommonResult.success();
	}

	@RequestMapping(value="/v1.0/buyer/orderDetails", method = RequestMethod.GET)
	public CommonResult orderDetails(@RequestParam("orderSn") String orderSn){
		OrderShowVO data = orderService.orderDetails(orderSn);
		return CommonResult.success(data);
	}
}

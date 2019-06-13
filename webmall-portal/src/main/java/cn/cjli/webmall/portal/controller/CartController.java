package cn.cjli.webmall.portal.controller;

import cn.cjli.webmall.common.vo.CommonResult;
import cn.cjli.webmall.portal.ro.CartAddRO;
import cn.cjli.webmall.portal.service.CartService;
import cn.cjli.webmall.portal.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * webmall cn.cjli.webmall.portal.controller
 *
 * @author Lichaojie
 * @version 2019/6/4 9:59
 */
@RestController
@CrossOrigin
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/v1.0/buyer/cart",method = RequestMethod.POST)
	public CommonResult addToCart(@RequestBody CartAddRO cartAddRO){
		cartService.addToCart(cartAddRO.getBuyerId(),
				cartAddRO.getCommodityId(),
				cartAddRO.getQuantity());
		return CommonResult.success();
	}


	@RequestMapping(value = "/v1.0/buyer/cart", method = RequestMethod.GET)
	public CommonResult<List<CartVO>> showCart(@RequestParam("buyerId") long buyerId){
		List<CartVO> data = cartService.showCart(buyerId);
		return CommonResult.success(data);
	}

	@RequestMapping(value = "/v1.0/buyer/cart", method = RequestMethod.DELETE)
	public CommonResult deleteCart(@RequestParam("buyerId") long buyerId,
								   @RequestParam("commodityId") long commodityId){
		cartService.deleteCart(buyerId,commodityId);
		return CommonResult.success();
	}
}

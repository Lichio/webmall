package cn.cjli.webmall.portal.controller;

import cn.cjli.webmall.common.vo.CommonResult;
import cn.cjli.webmall.data.entity.Commodity;
import cn.cjli.webmall.portal.ro.CommodityAddRO;
import cn.cjli.webmall.portal.ro.CommodityUpdateRO;
import cn.cjli.webmall.portal.service.CommodityService;
import cn.cjli.webmall.portal.vo.BuyerCommodityDetailVO;
import cn.cjli.webmall.portal.vo.SellerCommodityDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


/**
 * webmall cn.cjli.webmall.portal.controller
 *
 * @author Lichaojie
 * @version 2019/6/3 16:23
 */
@RestController
@CrossOrigin
public class CommodityController {

	@Autowired
	private CommodityService commodityService;

	/**
	 * 获取首页商品列表
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	@RequestMapping(value = "/v1.0/buyer/commodities", method = RequestMethod.GET)
	public CommonResult showCommodityList(@RequestParam("pageSize")Integer pageSize,
										  @RequestParam("pageNumber")Integer pageNumber){
		Page<Commodity> data = commodityService.showCommodityList(pageNumber, pageSize);
		return CommonResult.success(data);
	}


	/**
	 * 获取商品详情 buyer
	 * @param commodityId
	 * @return
	 */
	@RequestMapping(value = "/v1.0/buyer/commodity", method = RequestMethod.GET)
	public CommonResult<BuyerCommodityDetailVO> getBuyerCommodityDetail(@RequestParam("commodityId") Long commodityId){
		return CommonResult.success(commodityService.getBuyerCommodityDetail(commodityId));
	}


	/**
	 * 获取商品详情 seller
	 * @param commodityId
	 * @return
	 */
	@RequestMapping(value = "/v1.0/seller/commodity", method = RequestMethod.GET)
	public CommonResult<SellerCommodityDetailVO> getSellerCommodityDetail(@RequestParam("commodityId") Long commodityId){
		return CommonResult.success(commodityService.getSellerCommodityDetail(commodityId));
	}


	/**
	 * 新建商品
	 * @param commodityAddRO
	 * @return
	 */
	@RequestMapping(value = "/v1.0/seller/commodity", method = RequestMethod.POST)
	public CommonResult addCommodity(@RequestBody CommodityAddRO commodityAddRO){
		if (commodityService.addCommodity(commodityAddRO) != null){
			return CommonResult.success();
		}else {
			return CommonResult.failed();
		}
	}


	/**
	 * 修改商品
	 * @param commodityUpdateRO
	 * @return
	 */
	@RequestMapping(value = "/v1.0/seller/commodity", method = RequestMethod.PUT)
	public CommonResult updateCommodity(@RequestBody CommodityUpdateRO commodityUpdateRO){
		commodityService.updateCommodity(commodityUpdateRO);
		return CommonResult.success();
	}

	/**
	 * 删除商品
	 * @param commodityId
	 * @return
	 */
	@RequestMapping(value = "/v1.0/seller/commodity", method = RequestMethod.DELETE)
	public CommonResult deleteCommodity(@RequestParam("commodityId")long commodityId){
		commodityService.deleteCommodity(commodityId);
		return CommonResult.success();
	}


	/**
	 * 获取店铺中商品列表
	 * @param sellerId
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	@RequestMapping(value = "/v1.0/seller/commodities", method = RequestMethod.GET)
	public CommonResult showCommoditiesOfShop(@RequestParam("sellerId")long sellerId,
											  @RequestParam("pageSize")int pageSize,
											  @RequestParam("pageNumber")int pageNumber){
		Page<Commodity> data = commodityService.showCommoditiesOfShop(sellerId,pageNumber,pageSize);
		return CommonResult.success(data);
	}
}

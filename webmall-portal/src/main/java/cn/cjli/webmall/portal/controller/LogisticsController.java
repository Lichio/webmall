package cn.cjli.webmall.portal.controller;

import cn.cjli.webmall.common.vo.CommonResult;
import cn.cjli.webmall.portal.service.LogisticsService;
import cn.cjli.webmall.portal.vo.LogisticsStatusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * webmall cn.cjli.webmall.portal.controller
 *
 * @author Lichaojie
 * @version 2019/6/4 16:17
 */
@RestController
public class LogisticsController {

	@Autowired
	private LogisticsService logisticsService;

	@RequestMapping(value = "/v1.0/buyer/logistics", method = RequestMethod.GET)
	public CommonResult<LogisticsStatusVO> showLogisticsStatus(@RequestParam("orderSn") String orderSn){
		LogisticsStatusVO data = logisticsService.showStatus(orderSn);
		return CommonResult.success(data);
	}
}

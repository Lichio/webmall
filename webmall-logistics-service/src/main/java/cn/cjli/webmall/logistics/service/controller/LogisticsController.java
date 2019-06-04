package cn.cjli.webmall.logistics.service.controller;

import cn.cjli.webmall.common.vo.CommonResult;
import cn.cjli.webmall.data.repository.LogisticsRepository;
import cn.cjli.webmall.logistics.service.impl.service.LogisticsService;
import cn.cjli.webmall.logistics.service.ro.LogisticsRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * webmall cn.cjli.webmall.logistics.service.controller
 *
 * @author Lichaojie
 * @version 2019/6/4 17:51
 */
@RestController
public class LogisticsController {

	@Autowired
	private LogisticsService logisticsService;

	@RequestMapping(value = "/v1.0/logistics",method = RequestMethod.POST)
	public CommonResult newLogistics(@RequestBody LogisticsRO logisticsRO){
		logisticsService.newLogistics(logisticsRO.getOrderSn(),logisticsRO.getStatus());
		return CommonResult.success();
	}

	@RequestMapping(value = "/v1.0/logistics", method = RequestMethod.PUT)
	public CommonResult updateLogistics(@RequestBody LogisticsRO logisticsRO){
		logisticsService.updateLogistics(logisticsRO.getOrderSn(),logisticsRO.getStatus());
		return CommonResult.success();
	}
}

package cn.cjli.webmall.logistics.service.impl.service;

import cn.cjli.webmall.data.entity.Logistics;

/**
 * webmall cn.cjli.webmall.logistics.service.impl.service
 *
 * @author Lichaojie
 * @version 2019/6/4 17:57
 */
public interface LogisticsService {
	Logistics newLogistics(String orderSn, byte status);

	int updateLogistics(String orderSn, byte status);
}

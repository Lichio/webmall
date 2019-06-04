package cn.cjli.webmall.logistics.service.impl;

import cn.cjli.webmall.data.entity.Logistics;
import cn.cjli.webmall.data.repository.LogisticsRepository;
import cn.cjli.webmall.logistics.service.impl.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * webmall cn.cjli.webmall.logistics.service.impl
 *
 * @author Lichaojie
 * @version 2019/6/4 18:07
 */
@Service
public class LogisticsServiceImpl implements LogisticsService {

	@Autowired
	private LogisticsRepository logisticsRepository;

	@Override
	public Logistics newLogistics(String orderSn, byte status) {
		Logistics logistics = new Logistics();
		logistics.setOrderSn(orderSn);
		logistics.setStatus(status);
		return logisticsRepository.save(logistics);
	}

	@Override
	public int updateLogistics(String orderSn, byte status) {
		return logisticsRepository.updateStatus(orderSn,status);
	}
}

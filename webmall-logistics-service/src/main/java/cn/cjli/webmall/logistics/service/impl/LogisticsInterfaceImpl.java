package cn.cjli.webmall.logistics.service.impl;

import cn.cjli.webmall.data.entity.Logistics;
import cn.cjli.webmall.data.repository.LogisticsRepository;
import cn.cjli.webmall.logistics.api.interfaces.LogisticsInterface;
import cn.cjli.webmall.logistics.api.vo.LogisticsStatusDTO;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * webmall cn.cjli.webmall.logistics.service.impl
 *
 * @author Lichaojie
 * @version 2019/6/4 16:30
 */
@Service
public class LogisticsInterfaceImpl implements LogisticsInterface {

	@Autowired
	private LogisticsRepository logisticsRepository;

	@Override
	public LogisticsStatusDTO getLogisticsStatus(String orderSn) {
		LogisticsStatusDTO statusDTO = new LogisticsStatusDTO();
		Logistics logistics = logisticsRepository.getByOrderSn(orderSn);
		if (logistics != null){
			statusDTO.setOrderSn(logistics.getOrderSn());
			statusDTO.setStatus(logistics.getStatus());
		}
		return statusDTO;
	}
}

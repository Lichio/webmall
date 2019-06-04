package cn.cjli.webmall.portal.service.impl;

import cn.cjli.webmall.logistics.api.vo.LogisticsStatusDTO;
import cn.cjli.webmall.portal.manager.RpcManager;
import cn.cjli.webmall.portal.service.LogisticsService;
import cn.cjli.webmall.portal.vo.LogisticsStatusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * webmall cn.cjli.webmall.portal.service.impl
 *
 * @author Lichaojie
 * @version 2019/6/4 16:20
 */
@Service
public class LogisticsServiceImpl implements LogisticsService {
	@Autowired
	private RpcManager rpcManager;

	@Override
	public LogisticsStatusVO showStatus(String orderSn) {
		return rpcManager.showLogisticsStatus(orderSn);
	}
}

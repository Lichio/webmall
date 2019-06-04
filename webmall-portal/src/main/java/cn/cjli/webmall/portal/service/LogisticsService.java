package cn.cjli.webmall.portal.service;

import cn.cjli.webmall.portal.vo.LogisticsStatusVO;

/**
 * webmall cn.cjli.webmall.portal.service
 *
 * @author Lichaojie
 * @version 2019/5/22 10:30
 */
public interface LogisticsService {
	LogisticsStatusVO showStatus(String orderSn);
}

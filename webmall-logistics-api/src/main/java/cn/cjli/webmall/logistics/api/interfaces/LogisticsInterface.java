package cn.cjli.webmall.logistics.api.interfaces;

import cn.cjli.webmall.logistics.api.vo.LogisticsStatusDTO;

/**
 * webmall cn.cjli.webmall.logistics.api.interfaces
 *
 * @author Lichaojie
 * @version 2019/6/4 16:29
 */
public interface LogisticsInterface {
	LogisticsStatusDTO getLogisticsStatus(String orderSn);
}

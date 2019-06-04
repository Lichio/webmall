package cn.cjli.webmall.logistics.api.vo;

import java.io.Serializable;

/**
 * webmall cn.cjli.webmall.logistics.api.vo
 *
 * @author Lichaojie
 * @version 2019/6/4 16:26
 */
public class LogisticsStatusDTO implements Serializable {
	private String orderSn;

	private byte status;

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}
}

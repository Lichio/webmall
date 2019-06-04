package cn.cjli.webmall.logistics.service.ro;

/**
 * webmall cn.cjli.webmall.logistics.service.ro
 *
 * @author Lichaojie
 * @version 2019/6/4 18:03
 */
public class LogisticsRO {
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

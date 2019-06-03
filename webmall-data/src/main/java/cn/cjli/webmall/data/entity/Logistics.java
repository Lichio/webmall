package cn.cjli.webmall.data.entity;

import javax.persistence.*;

/**
 * webmall cn.cjli.webmall.data.entity
 *
 * @author Lichaojie
 * @version 2019/6/2 18:30
 */
@Table(name = "tb_logistics")
@Entity
public class Logistics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "logistics_id")
	private long logisticsId;

	@Column(name = "order_sn")
	private String orderSn;

	@Column(name = "status")
	private byte status;

	public long getLogisticsId() {
		return logisticsId;
	}

	public void setLogisticsId(long logisticsId) {
		this.logisticsId = logisticsId;
	}

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

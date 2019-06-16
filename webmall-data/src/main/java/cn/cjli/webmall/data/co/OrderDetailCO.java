package cn.cjli.webmall.data.co;

import java.util.Date;

/**
 * webmall cn.cjli.webmall.data.co
 *
 * @author Lichaojie
 * @version 2019/6/4 12:14
 */
public class OrderDetailCO {

	private String orderSn;

	private long commodityId;

	private String name;

	private String picture;

	private int quantity;

	private double totalValue;

	private Date createTime;

	private byte status;

	private double price;

	public OrderDetailCO(String orderSn, long commodityId, String name, String picture, int quantity, double totalValue, Date createTime, byte status, double price) {
		this.orderSn = orderSn;
		this.commodityId = commodityId;
		this.name = name;
		this.picture = picture;
		this.quantity = quantity;
		this.totalValue = totalValue;
		this.createTime = createTime;
		this.status = status;
		this.price = price;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public OrderDetailCO setPrice(double price) {
		this.price = price;
		return this;
	}
}

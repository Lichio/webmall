package cn.cjli.webmall.data.co;

import java.util.Date;

/**
 * webmall cn.cjli.webmall.data.co
 *
 * @author Lichaojie
 * @version 2019/6/4 17:16
 */
public class CartDetailCO {

	private long commodityId;

	private String name;

	private String picture;

	private int quantity;

	private double price;

	private Date createTime;

	public CartDetailCO(long commodityId, String name, String picture, int quantity, double price, Date createTime) {
		this.commodityId = commodityId;
		this.name = name;
		this.picture = picture;
		this.quantity = quantity;
		this.price = price;
		this.createTime = createTime;
	}

	public long getCommodityId() {
		return commodityId;
	}

	public CartDetailCO setCommodityId(long commodityId) {
		this.commodityId = commodityId;
		return this;
	}

	public String getName() {
		return name;
	}

	public CartDetailCO setName(String name) {
		this.name = name;
		return this;
	}

	public String getPicture() {
		return picture;
	}

	public CartDetailCO setPicture(String picture) {
		this.picture = picture;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public CartDetailCO setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public double getPrice() {
		return price;
	}

	public CartDetailCO setPrice(double price) {
		this.price = price;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public CartDetailCO setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
}

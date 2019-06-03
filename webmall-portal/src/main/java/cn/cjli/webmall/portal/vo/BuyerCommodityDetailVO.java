package cn.cjli.webmall.portal.vo;

import javax.persistence.Column;

/**
 * webmall cn.cjli.webmall.portal.vo
 *
 * @author Lichaojie
 * @version 2019/6/3 16:45
 */
public class BuyerCommodityDetailVO {

	private long commodityId;

	private String name;

	private String description;

	private String picture;

	private int quantity;

	private double price;

	private long sellerId;

	private String shop;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}
}

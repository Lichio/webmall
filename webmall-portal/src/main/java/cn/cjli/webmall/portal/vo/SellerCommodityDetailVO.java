package cn.cjli.webmall.portal.vo;

/**
 * webmall cn.cjli.webmall.portal.vo
 *
 * @author Lichaojie
 * @version 2019/6/3 17:01
 */
public class SellerCommodityDetailVO {
	private long commodityId;

	private String name;

	private String description;

	private String picture;

	private int quantity;

	private double price;

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
}

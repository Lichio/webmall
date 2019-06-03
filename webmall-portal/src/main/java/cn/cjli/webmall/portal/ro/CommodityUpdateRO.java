package cn.cjli.webmall.portal.ro;

/**
 * webmall cn.cjli.webmall.portal.ro
 *
 * @author Lichaojie
 * @version 2019/6/3 17:34
 */
public class CommodityUpdateRO {
	private long commodityId;

	private String name;

	private String picture;

	private String description;

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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

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

	private Date createTime;

	public CartDetailCO(long commodityId, String name, String picture, int quantity, Date createTime) {
		this.commodityId = commodityId;
		this.name = name;
		this.picture = picture;
		this.quantity = quantity;
		this.createTime = createTime;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}

package cn.cjli.webmall.portal.ro;

/**
 * webmall cn.cjli.webmall.portal.ro
 *
 * @author Lichaojie
 * @version 2019/6/4 10:33
 */
public class OrderAddRO {
	private long commodityId;

	private int quantity;

	private double totalValue;

	private long buyerId;

	private String address;

	public long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
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

	public long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

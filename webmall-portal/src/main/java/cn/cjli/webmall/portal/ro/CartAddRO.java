package cn.cjli.webmall.portal.ro;

/**
 * webmall cn.cjli.webmall.portal.ro
 *
 * @author Lichaojie
 * @version 2019/6/4 10:01
 */
public class CartAddRO {
	private long buyerId;

	private long commodityId;

	private int quantity;

	public long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}

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
}

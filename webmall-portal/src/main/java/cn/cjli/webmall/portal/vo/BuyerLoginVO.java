package cn.cjli.webmall.portal.vo;

/**
 * webmall cn.cjli.webmall.portal.vo
 *
 * @author Lichaojie
 * @version 2019/6/3 16:04
 */
public class BuyerLoginVO {
	private Long buyerId;

	private String username;

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}

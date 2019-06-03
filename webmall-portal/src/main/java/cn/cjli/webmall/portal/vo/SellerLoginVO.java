package cn.cjli.webmall.portal.vo;

/**
 * webmall cn.cjli.webmall.portal.vo
 *
 * @author Lichaojie
 * @version 2019/6/3 16:05
 */
public class SellerLoginVO {
	private Long sellerId;

	private String username;

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}

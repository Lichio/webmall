package cn.cjli.webmall.portal.domain;

/**
 * webmall cn.cjli.webmall.portal.domain
 *
 * @author Lichaojie
 * @version 2019/6/3 14:18
 */
public enum RoleType {
	/**
	 *
	 */
	BUYER("buyer"),
	SELLER("seller");

	private String value;

	private RoleType(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

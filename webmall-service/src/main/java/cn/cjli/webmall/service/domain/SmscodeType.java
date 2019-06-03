package cn.cjli.webmall.service.domain;

/**
 * webmall cn.cjli.webmall.service.domain
 *
 * @author Lichaojie
 * @version 2019/6/3 14:43
 */
public enum SmscodeType {

	/**
	 *
	 */
	REGISTER("register"),
	LOGIN("login"),
	CHANGE_PASSWORD("changePassword");

	private String value;

	private SmscodeType(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

package cn.cjli.webmall.common.vo;

/**
 * webmall cn.cjli.webmall.common.vo
 *
 * @author Lichaojie
 * @version 2019/5/21 11:19
 */
public enum ResultCode {
	/**
	 *
	 */
	SUCCESS(200, "SUCCESS"),
	FAILED(500, "FAILED"),
	VALIDATE_FAILED(404, "VALIDATE_FAILED");
	private long code;
	private String message;

	private ResultCode(long code, String message) {
		this.code = code;
		this.message = message;
	}

	public long getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}

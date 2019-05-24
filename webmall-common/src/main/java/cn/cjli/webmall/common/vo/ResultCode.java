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
	SUCCESS(200, "操作成功"),
	FAILED(500, "操作失败"),
	VALIDATE_FAILED(404, "参数检验失败");
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

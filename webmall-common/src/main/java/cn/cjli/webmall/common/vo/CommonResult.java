package cn.cjli.webmall.common.vo;

/**
 * webmall cn.cjli.webmall.common.vo
 *
 * @author Lichaojie
 * @version 2019/5/21 11:11
 */
public class CommonResult<T> {
	private long code;
	private String message;
	private T data;

	protected CommonResult() {
	}

	protected CommonResult(long code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * 成功返回结果
	 *
	 * @param data 获取的数据
	 */
	public static <T> CommonResult<T> success(T data) {
		return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
	}

	public static <T> CommonResult<T> success(){
		return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
	}

	/**
	 * 成功返回结果
	 *
	 * @param data 获取的数据
	 * @param  message 提示信息
	 */
	public static <T> CommonResult<T> success(T data, String message) {
		return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
	}

	/**
	 * 失败返回结果
	 * @param errorCode 错误码
	 */
	public static <T> CommonResult<T> failed(ResultCode errorCode) {
		return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
	}

	/**
	 * 失败返回结果
	 * @param message 提示信息
	 */
	public static <T> CommonResult<T> failed(String message) {
		return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
	}

	/**
	 * 失败返回结果
	 */
	public static <T> CommonResult<T> failed() {
		return failed(ResultCode.FAILED);
	}

	/**
	 * 参数验证失败返回结果
	 */
	public static <T> CommonResult<T> validateFailed() {
		return failed(ResultCode.VALIDATE_FAILED);
	}

	/**
	 * 参数验证失败返回结果
	 * @param message 提示信息
	 */
	public static <T> CommonResult<T> validateFailed(String message) {
		return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
	}


	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}

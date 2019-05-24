package cn.cjli.webmall.logistics.api.vo;

import java.io.Serializable;

/**
 * webmall cn.cjli.webmall.logistics.api.vo
 *
 * @author Lichaojie
 * @version 2019/5/21 19:46
 */
public class TestVO implements Serializable {
	private String name;
	private String info;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}

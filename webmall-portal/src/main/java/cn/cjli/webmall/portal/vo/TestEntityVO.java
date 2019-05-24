package cn.cjli.webmall.portal.vo;

import cn.cjli.webmall.data.entity.TestEntity;

import java.io.Serializable;

/**
 * webmall cn.cjli.webmall.portal.vo
 *
 * @author Lichaojie
 * @version 2019/5/21 10:53
 */
public class TestEntityVO implements Serializable {
	private String name;
	private String info;
	private byte type;

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

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}
}

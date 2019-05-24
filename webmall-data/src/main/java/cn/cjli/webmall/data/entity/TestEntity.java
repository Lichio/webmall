package cn.cjli.webmall.data.entity;

import javax.persistence.*;

/**
 * webmall cn.cjli.webmall.data.entity
 *
 * @author Lichaojie
 * @version 2019/5/20 19:41
 */
@Table
@Entity
public class TestEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "entity_id")
	private long entityId;

	@Column(name = "name")
	private String name;

	@Column(name = "info")
	private String info;

	@Column(name = "type")
	private byte type;

	public long getEntityId() {
		return entityId;
	}

	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

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

package cn.cjli.webmall.data.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * webmall cn.cjli.webmall.data.entity
 *
 * @author Lichaojie
 * @version 2019/6/2 18:21
 */
@Table(name = "tb_cart")
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private long cartId;

	@Column(name = "buyer_id")
	private long buyerId;

	@Column(name = "commodity_id")
	private long commodityId;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "is_deleted")
	private boolean deleted;


}

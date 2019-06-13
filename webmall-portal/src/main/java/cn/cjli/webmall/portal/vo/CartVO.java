package cn.cjli.webmall.portal.vo;

import cn.cjli.webmall.data.co.CartDetailCO;

import java.util.Date;

/**
 * webmall cn.cjli.webmall.portal.vo
 *
 * @author Lichaojie
 * @version 2019/6/4 10:11
 */
public class CartVO extends CartDetailCO {

	private boolean checked;

	public CartVO(long commodityId, String name, String picture, int quantity, Date createTime,double price,boolean checked) {
		super(commodityId, name, picture, quantity,price, createTime);
	}

	public static CartVO cast(CartDetailCO co){
		return new CartVO(co.getCommodityId(),
				co.getName(),
				co.getPicture(),
				co.getQuantity(),
				co.getCreateTime(),
				co.getPrice(),
				true
				);
	}

	public boolean isChecked() {
		return checked;
	}

	public CartVO setChecked(boolean checked) {
		this.checked = checked;
		return this;
	}
}

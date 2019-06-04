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


	public CartVO(long commodityId, String name, String picture, int quantity, Date createTime) {
		super(commodityId, name, picture, quantity, createTime);
	}

	public static CartVO cast(CartDetailCO co){
		return new CartVO(co.getCommodityId(),
				co.getName(),
				co.getPicture(),
				co.getQuantity(),
				co.getCreateTime());
	}
}

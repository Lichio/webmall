package cn.cjli.webmall.portal.service;

import cn.cjli.webmall.data.entity.Cart;
import cn.cjli.webmall.portal.vo.CartVO;

import java.util.List;

/**
 * webmall cn.cjli.webmall.portal.service
 *
 * @author Lichaojie
 * @version 2019/6/4 10:02
 */
public interface CartService {

	Cart addToCart(long buyerId, long commodityId, int quantity);

	List<CartVO> showCart(long buyerId);

	void deleteCart(long buyerId, long commodityId);
}

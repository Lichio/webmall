package cn.cjli.webmall.portal.service.impl;

import cn.cjli.webmall.data.co.CartDetailCO;
import cn.cjli.webmall.data.entity.Cart;
import cn.cjli.webmall.data.repository.CartRepository;
import cn.cjli.webmall.data.repository.CommodityRepository;
import cn.cjli.webmall.portal.service.CartService;
import cn.cjli.webmall.portal.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * webmall cn.cjli.webmall.portal.service.impl
 *
 * @author Lichaojie
 * @version 2019/6/4 10:03
 */
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CommodityRepository commodityRepository;

	@Override
	public Cart addToCart(long buyerId, long commodityId, int quantity) {
		Cart cart = cartRepository.getByCommodityIdAndBuyerId(commodityId,buyerId);
		if (cart == null){
			cart = new Cart();
			cart.setBuyerId(buyerId);
			cart.setCommodityId(commodityId);
			cart.setQuantity(quantity);
			cart.setCreateTime(new Date());
			cart.setDeleted(false);
			cart =  cartRepository.save(cart);
		} else {
			int num = cart.getQuantity() + quantity;
			cartRepository.updateQuantity(cart.getCartId(),num);
			cart.setQuantity(num);
		}
		return cart;
	}

	@Override
	public List<CartVO> showCart(long buyerId) {
		List<CartDetailCO> dataCO = cartRepository.findCartDetailByBuyerId(buyerId);
		List<CartVO> dataVO = new ArrayList<>();
		dataCO.forEach(e ->dataVO.add(CartVO.cast(e)));
		return dataVO;
	}

	@Override
	public void deleteCart(long buyerId, long commodityId) {
		cartRepository.logicallyDelete(buyerId,commodityId);
	}
}

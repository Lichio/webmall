package cn.cjli.webmall.data.repository;

import cn.cjli.webmall.data.co.CartDetailCO;
import cn.cjli.webmall.data.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * webmall cn.cjli.webmall.data.repository
 *
 * @author Lichaojie
 * @version 2019/6/3 14:28
 */
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query(value = "select new cn.cjli.webmall.data.co.CartDetailCO(c1.commodityId, c2.name, c2.picture, c1.quantity, c2.price, c1.createTime) " +
			"from cn.cjli.webmall.data.entity.Cart c1, cn.cjli.webmall.data.entity.Commodity c2 " +
			"where c1.buyerId = ?1 and c2.commodityId = c1.commodityId")
	List<CartDetailCO> findCartDetailByBuyerId(long buyerId);

	Cart getByCommodityIdAndBuyerId(long commodityId, long buyerId);

	@Transactional
	@Modifying
	@Query(value = "update Cart c set c.quantity = ?2 where c.cartId = ?1")
	int updateQuantity(long cartId, int quantity);

	@Transactional
	@Modifying
	@Query(value = "update Cart c set c.deleted=true where c.buyerId = ?1 and c.commodityId = ?2")
	int logicallyDelete(long buyerId, long commodityId);
}

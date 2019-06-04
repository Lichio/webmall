package cn.cjli.webmall.data.repository;

import cn.cjli.webmall.data.co.CartDetailCO;
import cn.cjli.webmall.data.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * webmall cn.cjli.webmall.data.repository
 *
 * @author Lichaojie
 * @version 2019/6/3 14:28
 */
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query(value = "select new cn.cjli.webmall.data.co.CartDetailCO(c1.commodityId, c2.name, c2.picture, c1.quantity, c1.createTime) " +
			"from cn.cjli.webmall.data.entity.Cart c1, cn.cjli.webmall.data.entity.Commodity c2 " +
			"where c1.buyerId = ?1 and c2.commodityId = c1.commodityId")
	List<CartDetailCO> findCartDetailByBuyerId(long buyerId);
}

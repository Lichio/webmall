package cn.cjli.webmall.data.repository;

import cn.cjli.webmall.data.co.OrderDetailCO;
import cn.cjli.webmall.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * webmall cn.cjli.webmall.data.repository
 *
 * @author Lichaojie
 * @version 2019/6/3 14:30
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query(value = "select new cn.cjli.webmall.data.co.OrderDetailCO(o.orderSn, o.commodityId, c.name, c.picture, o.quantity, o.totalValue, o.createTime, o.status) " +
			"from cn.cjli.webmall.data.entity.Order o, cn.cjli.webmall.data.entity.Commodity c " +
			"where o.buyerId = ?1 and c.commodityId = o.commodityId")
	List<OrderDetailCO> findOrdersDetailByBuyerId(long buyerId);

	@Query(value = "select new cn.cjli.webmall.data.co.OrderDetailCO(o.orderSn, o.commodityId, c.name, c.picture, o.quantity, o.totalValue, o.createTime, o.status) " +
			"from cn.cjli.webmall.data.entity.Order o, cn.cjli.webmall.data.entity.Commodity c " +
			"where o.sellerId = ?1 and c.commodityId = o.commodityId")
	List<OrderDetailCO> findOrdersDetailBySellerId(long sellerId);
}

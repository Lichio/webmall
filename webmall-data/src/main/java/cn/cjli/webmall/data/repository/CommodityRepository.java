package cn.cjli.webmall.data.repository;

import cn.cjli.webmall.data.entity.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


/**
 * webmall cn.cjli.webmall.data.repository
 *
 * @author Lichaojie
 * @version 2019/6/3 14:29
 */
public interface CommodityRepository extends JpaRepository<Commodity, Long> {
	Commodity getByCommodityIdAndDeleted(long commodityId, boolean deleted);

	Page<Commodity> findCommoditiesByDeleted(Pageable pageable, boolean deleted);

	Page<Commodity> findCommoditiesBySellerIdAndDeleted(Pageable pageable, long sellerId, boolean deleted);

	@Transactional
	@Modifying
	@Query(value = "update Commodity c set c.name = ?2 , c.picture = ?3 , c.description = ?4 ," +
			"c.quantity = ?5 , c.price = ?6 where c.commodityId = ?1")
	int updateCommodity(long commodityId,
						String name,
						String picture,
						String description,
						int quantity,
						double price);

	@Transactional
	@Modifying
	@Query(value = "update Commodity c set c.deleted = true where c.commodityId = ?1")
	int logicallyDelete(long commodityId);
}

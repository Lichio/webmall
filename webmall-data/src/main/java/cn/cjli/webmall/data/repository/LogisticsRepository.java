package cn.cjli.webmall.data.repository;

import cn.cjli.webmall.data.entity.Logistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * webmall cn.cjli.webmall.data.repository
 *
 * @author Lichaojie
 * @version 2019/6/3 14:30
 */
public interface LogisticsRepository extends JpaRepository<Logistics, Long> {
	Logistics getByOrderSn(String orderSn);

	@Transactional
	@Modifying
	@Query(value = "update Logistics l set l.status = ?2 where l.orderSn = ?1")
	int updateStatus(String orderSn, byte status);
}

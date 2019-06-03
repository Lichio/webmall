package cn.cjli.webmall.data.repository;

import cn.cjli.webmall.data.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


/**
 * webmall cn.cjli.webmall.data.repository
 *
 * @author Lichaojie
 * @version 2019/6/3 14:27
 */
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

	Buyer getByUsername(String username);

	@Transactional
	@Modifying
	@Query(value = "update Buyer b set b.password= ?2 where b.username= ?1")
	int update(String username, String password);
}

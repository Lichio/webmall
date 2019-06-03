package cn.cjli.webmall.data.repository;

import cn.cjli.webmall.data.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * webmall cn.cjli.webmall.data.repository
 *
 * @author Lichaojie
 * @version 2019/6/3 14:31
 */
public interface SellerRepository extends JpaRepository<Seller, Long> {

	Seller getByUsername(String username);

	@Transactional
	@Modifying
	@Query(value = "update Seller s set s.password= ?2 where s.username= ?1 ")
	int update(String username, String password);
}

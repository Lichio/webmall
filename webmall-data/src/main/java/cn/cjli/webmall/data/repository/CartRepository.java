package cn.cjli.webmall.data.repository;

import cn.cjli.webmall.data.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * webmall cn.cjli.webmall.data.repository
 *
 * @author Lichaojie
 * @version 2019/6/3 14:28
 */
public interface CartRepository extends JpaRepository<Cart, Long> {
}

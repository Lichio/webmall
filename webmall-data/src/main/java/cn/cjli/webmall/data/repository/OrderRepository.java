package cn.cjli.webmall.data.repository;

import cn.cjli.webmall.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * webmall cn.cjli.webmall.data.repository
 *
 * @author Lichaojie
 * @version 2019/6/3 14:30
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
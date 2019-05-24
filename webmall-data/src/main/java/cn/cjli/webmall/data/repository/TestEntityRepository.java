package cn.cjli.webmall.data.repository;

import cn.cjli.webmall.data.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * webmall cn.cjli.webmall.data.repository
 *
 * @author Lichaojie
 * @version 2019/5/20 19:58
 */
public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {

}

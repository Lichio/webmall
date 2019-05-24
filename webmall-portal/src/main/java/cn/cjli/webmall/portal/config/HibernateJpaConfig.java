package cn.cjli.webmall.portal.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * webmall cn.cjli.webmall.data.config
 *
 * @author Lichaojie
 * @version 2019/5/20 19:55
 */
@Configuration
@EntityScan(value = "cn.cjli.webmall.data.entity")
@EnableJpaRepositories(value = "cn.cjli.webmall.data.repository")
@EnableTransactionManagement
public class HibernateJpaConfig {
}

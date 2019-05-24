package cn.cjli.webmall.logistics.service.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * webmall cn.cjli.webmall.logistics.service.config
 *
 * @author Lichaojie
 * @version 2019/5/22 9:40
 */
@Configuration
@EntityScan(value = "cn.cjli.webmall.data.entity")
@EnableJpaRepositories(value = "cn.cjli.webmall.data.repository")
@EnableTransactionManagement
public class HibernateJpaConfig {
}

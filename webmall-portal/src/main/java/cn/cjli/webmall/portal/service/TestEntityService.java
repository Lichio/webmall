package cn.cjli.webmall.portal.service;

import cn.cjli.webmall.data.entity.TestEntity;
import cn.cjli.webmall.logistics.api.vo.TestVO;
import cn.cjli.webmall.portal.vo.TestEntityVO;

/**
 * webmall cn.cjli.webmall.portal.service
 *
 * @author Lichaojie
 * @version 2019/5/20 20:09
 */
public interface TestEntityService {
	void saveEntity(TestEntity entity);

	TestEntityVO getEntity(Long id);

	TestVO getInfo(Long id);
}

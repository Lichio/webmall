package cn.cjli.webmall.portal.service.impl;

import cn.cjli.webmall.data.entity.TestEntity;
import cn.cjli.webmall.data.repository.TestEntityRepository;
import cn.cjli.webmall.logistics.api.vo.TestVO;
import cn.cjli.webmall.portal.manager.RpcManager;
import cn.cjli.webmall.portal.service.TestEntityService;
import cn.cjli.webmall.portal.util.RabbitMQUtil;
import cn.cjli.webmall.portal.util.RedisUtil;
import cn.cjli.webmall.portal.vo.TestEntityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * webmall cn.cjli.webmall.portal.service.impl
 *
 * @author Lichaojie
 * @version 2019/5/20 20:10
 */
@Service
public class TestEntiryServiceImpl implements TestEntityService {
	@Autowired
	private TestEntityRepository testEntityRepository;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private RabbitMQUtil rabbitMQUtil;
	@Autowired
	private RpcManager rpcManager;

	@Override
	public void saveEntity(TestEntity entity) {
		testEntityRepository.save(entity);
		//redisUtil.set("user-" + entity.getEntityId(),entity);

		//rabbitMQUtil.sendMessage("notification",entity);
	}

	@Override
	public TestEntityVO getEntity(Long id) {
		TestEntity testEntity = testEntityRepository.getOne(id);
		TestEntityVO entityVO = new TestEntityVO();
		entityVO.setName(testEntity.getName());
		entityVO.setInfo(testEntity.getInfo());
		entityVO.setType(testEntity.getType());
		rabbitMQUtil.sendMessage("testNotify",entityVO);
		return entityVO;
	}

	@Override
	public TestVO getInfo(Long id) {
		return rpcManager.getInfo(id);
	}
}

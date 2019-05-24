package cn.cjli.webmall.logistics.service.impl;

import cn.cjli.webmall.data.entity.TestEntity;
import cn.cjli.webmall.data.repository.TestEntityRepository;
import cn.cjli.webmall.logistics.api.interfaces.TestInterface;
import cn.cjli.webmall.logistics.api.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * webmall cn.cjli.webmall.logistics.service.impl
 *
 * @author Lichaojie
 * @version 2019/5/21 19:48
 */
@Service
public class TestInterfaceImpl implements TestInterface {
	@Autowired
	private TestEntityRepository testEntityRepository;

	@Override
	public TestVO getInfo(Long id) {
		TestEntity testEntity = testEntityRepository.getOne(id);
		TestVO testVO = new TestVO();
		testVO.setInfo(testEntity.getInfo());
		testVO.setName(testEntity.getName());
		return testVO;
	}
}

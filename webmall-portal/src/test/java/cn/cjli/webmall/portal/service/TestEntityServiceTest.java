package cn.cjli.webmall.portal.service;

import cn.cjli.webmall.portal.vo.TestEntityVO;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;

/**
 * webmall cn.cjli.webmall.portal.service
 *
 * @author Lichaojie
 * @version 2019/5/22 18:00
 */
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEntityServiceTest {

	@Autowired
	private TestEntityService testEntityService;

	@Test
	public void test(){
		TestEntityVO testEntityVO = testEntityService.getEntity(3L);
		Assert.assertThat(testEntityVO.getInfo(),is("info2"));
	}
}
package cn.cjli.webmall.portal.manager;

import cn.cjli.webmall.logistics.api.interfaces.TestInterface;
import cn.cjli.webmall.logistics.api.vo.TestVO;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * webmall cn.cjli.webmall.portal.manager
 *
 * @author Lichaojie
 * @version 2019/5/23 9:50
 */
@Service
public class RpcManager {

	/*
	@Reference(url = "dubbo://localhost:20880", check = false)
	private TestInterface testInterface;

	public TestVO getInfo(Long id){
		return testInterface.getInfo(id);
	}

	 */
	public TestVO getInfo(Long id){
		return new TestVO();
	}
}

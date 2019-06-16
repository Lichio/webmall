package cn.cjli.webmall.portal.manager;

import cn.cjli.webmall.logistics.api.interfaces.LogisticsInterface;
import cn.cjli.webmall.logistics.api.interfaces.TestInterface;
import cn.cjli.webmall.logistics.api.vo.LogisticsStatusDTO;
import cn.cjli.webmall.logistics.api.vo.TestVO;
import cn.cjli.webmall.portal.vo.LogisticsStatusVO;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * webmall cn.cjli.webmall.portal.manager
 *
 * @author Lichaojie
 * @version 2019/5/23 9:50
 */
@Service
public class RpcManager {


	@Reference(url = "dubbo://localhost:20881", check = false)
	private TestInterface testInterface;

	@Reference(url = "dubbo://localhost:20881", check = false)
	private LogisticsInterface logisticsInterface;

	public TestVO getInfo(Long id){
		return testInterface.getInfo(id);
	}

	public LogisticsStatusVO showLogisticsStatus(String orderSn){
		LogisticsStatusDTO statusDTO = logisticsInterface.getLogisticsStatus(orderSn);
		LogisticsStatusVO statusVO = new LogisticsStatusVO();
		if (statusDTO != null){
			statusVO.setOrderSn(statusDTO.getOrderSn());
			statusVO.setStatus(statusDTO.getStatus());
		}
		return statusVO;
	}



//	public TestVO getInfo(Long id){
//		return new TestVO();
//	}
}

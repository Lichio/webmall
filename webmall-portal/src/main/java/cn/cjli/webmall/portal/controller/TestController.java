package cn.cjli.webmall.portal.controller;

import cn.cjli.webmall.data.entity.TestEntity;
import cn.cjli.webmall.logistics.api.vo.TestVO;
import cn.cjli.webmall.portal.service.TestEntityService;
import cn.cjli.webmall.portal.vo.TestEntityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * webmall cn.cjli.webmall.portal.controller
 *
 * @author Lichaojie
 * @version 2019/5/20 20:05
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private TestEntityService entityService;

	@PostMapping(value = "/entity/save")
	public void saveEntiry(@RequestBody TestEntity testEntity){
		entityService.saveEntity(testEntity);
	}

	@GetMapping("/entity/get")
	public TestEntityVO getEntity(@RequestParam("id") Long id){
		return entityService.getEntity(id);
	}

	@GetMapping("/dubbo/get")
	public TestVO getInfo(@RequestParam("id") Long id){
		return entityService.getInfo(id);
	}
}

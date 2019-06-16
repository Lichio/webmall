package cn.cjli.webmall.portal.controller;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * webmall cn.cjli.webmall.portal.controller
 *
 * @author Lichaojie
 * @version 2019/5/23 10:17
 */
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mvc;

	@Before
	public void setupMockMvc(){
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void addEntity() throws Exception{
		JSONObject json = new JSONObject();
		json.put("name","mockName");
		json.put("info","mockInfo");
		json.put("type",1);

		mvc.perform(MockMvcRequestBuilders.post("/test/entity/save")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(json.toString().getBytes()) //传json参数
		)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void queryEntity() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/test/entity/get?id=2")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
		)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.info").value("info2"))
				.andDo(MockMvcResultHandlers.print());
	}
}
package cn.cjli.webmall.portal.service;

import cn.cjli.webmall.common.vo.CommonResult;

/**
 * webmall cn.cjli.webmall.portal.service
 *
 * @author Lichaojie
 * @version 2019/6/3 14:10
 */
public interface CommonService {
	CommonResult doRegister(String username, String password, String role);

	CommonResult resetPassword(String username, String password, String role);

	CommonResult passwordLogin(String username, String password, String role);

	CommonResult smscodeLogin(String username, String role);

	CommonResult checkLogin(String role, long id);
}

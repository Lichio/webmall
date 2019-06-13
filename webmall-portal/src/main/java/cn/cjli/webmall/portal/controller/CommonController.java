package cn.cjli.webmall.portal.controller;

import cn.cjli.webmall.common.vo.CommonResult;
import cn.cjli.webmall.portal.domain.RoleType;
import cn.cjli.webmall.portal.ro.*;
import cn.cjli.webmall.portal.service.CommonService;
import cn.cjli.webmall.portal.util.RedisUtil;
import cn.cjli.webmall.service.sms.SMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * webmall cn.cjli.webmall.portal.controller
 *
 * @author Lichaojie
 * @version 2019/6/3 12:52
 */
@RestController
@CrossOrigin
public class CommonController {

	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private CommonService commonService;

	/**
	 * 获取短信验证码
	 * @param type 验证码类型
	 * @param phone 手机号
	 * @return
	 */
	@RequestMapping(value = "/v1.0/smscode", method = RequestMethod.GET)
	public CommonResult getSmsCode(@RequestParam("type")String type,
								   @RequestParam("phone")String phone){
		String code = SMService.randomCode();
		if (SMService.sendSmscode(phone, code, type)){
			redisUtil.set(RedisUtil.KeyGenerator.createSmsKey(phone), code);
			return CommonResult.success();
		}else {
			return CommonResult.failed("验证码发送失败");
		}
	}

	/**
	 * 用户注册
	 * @param registerRO
	 * @return
	 */
	@RequestMapping(value = "/v1.0/register", method = RequestMethod.POST)
	public CommonResult register(@RequestBody RegisterRO registerRO){
		String smscode = redisUtil.get(RedisUtil.KeyGenerator.createSmsKey(registerRO.getUsername()));
		if (smscode != null && smscode.equals(registerRO.getSmscode())){
			return commonService.doRegister(registerRO.getUsername(),
					registerRO.getPassword(),
					registerRO.getRole());
		} else {
			return CommonResult.failed("验证码错误");
		}
	}


	/**
	 * 重置密码
	 * @param resetPasswordRO
	 * @return
	 */
	@RequestMapping(value = "/v1.0/password", method = RequestMethod.PUT)
	public CommonResult reset(@RequestBody ResetPasswordRO resetPasswordRO){
		String smscode = redisUtil.get(RedisUtil.KeyGenerator.createSmsKey(resetPasswordRO.getUsername()));
		if (smscode != null && smscode.equals(resetPasswordRO.getSmscode())){
			return commonService.resetPassword(resetPasswordRO.getUsername(),
					resetPasswordRO.getPassword(),
					resetPasswordRO.getRole());
		} else {
			return CommonResult.failed("验证码错误");
		}
	}


	/**
	 * 买家 密码 登录
	 * @param passwordLoginRO
	 * @return
	 */
	@RequestMapping(value = "/v1.0/buyer/passwordLogin", method = RequestMethod.POST)
	public CommonResult buyerPasswordLogin(@RequestBody PasswordLoginRO passwordLoginRO){
		return commonService.passwordLogin(passwordLoginRO.getUsername(),
				passwordLoginRO.getPassword(),
				RoleType.BUYER.getValue());
	}

	/**
	 * 买家 验证码 登录
	 * @param smscodeLoginRO
	 * @return
	 */
	@RequestMapping(value = "/v1.0/buyer/smscodeLogin", method = RequestMethod.POST)
	public CommonResult buyerSmscodeLogin(@RequestBody SmscodeLoginRO smscodeLoginRO){
		String smscode = redisUtil.get(RedisUtil.KeyGenerator.createSmsKey(smscodeLoginRO.getUsername()));
		if (smscode != null && smscode.equals(smscodeLoginRO.getSmscode())){
			return commonService.smscodeLogin(smscodeLoginRO.getUsername(), RoleType.BUYER.getValue());
		}else {
			return CommonResult.failed("验证码错误");
		}
	}


	/**
	 * 卖家 密码 登录
	 * @param passwordLoginRO
	 * @return
	 */
	@RequestMapping(value = "/v1.0/seller/passwordLogin", method = RequestMethod.POST)
	public CommonResult sellerPasswordLogin(@RequestBody PasswordLoginRO passwordLoginRO){
		return commonService.passwordLogin(passwordLoginRO.getUsername(),
				passwordLoginRO.getPassword(),
				RoleType.SELLER.getValue());
	}

	/**
	 * 卖家 验证码 登录
	 * @param smscodeLoginRO
	 * @return
	 */
	@RequestMapping(value = "/v1.0/seller/smscodeLogin", method = RequestMethod.POST)
	public CommonResult sellerSmscodeLogin(@RequestBody SmscodeLoginRO smscodeLoginRO){
		String smscode = redisUtil.get(RedisUtil.KeyGenerator.createSmsKey(smscodeLoginRO.getUsername()));
		if (smscode != null && smscode.equals(smscodeLoginRO.getSmscode())){
			return commonService.smscodeLogin(smscodeLoginRO.getUsername(), RoleType.SELLER.getValue());
		}else {
			return CommonResult.failed("验证码错误");
		}
	}

	@RequestMapping(value = "/v1.0/checkLogin", method = RequestMethod.GET)
	public CommonResult checkLogin(@RequestParam("role") String role,
								   @RequestParam("id") Long id){
		return commonService.checkLogin(role, id);
	}
}

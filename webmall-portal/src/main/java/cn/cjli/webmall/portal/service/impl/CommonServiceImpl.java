package cn.cjli.webmall.portal.service.impl;

import cn.cjli.webmall.common.vo.CommonResult;
import cn.cjli.webmall.data.entity.Buyer;
import cn.cjli.webmall.data.entity.Seller;
import cn.cjli.webmall.data.repository.BuyerRepository;
import cn.cjli.webmall.data.repository.SellerRepository;
import cn.cjli.webmall.portal.domain.QueueType;
import cn.cjli.webmall.portal.domain.RoleType;
import cn.cjli.webmall.portal.service.CommonService;
import cn.cjli.webmall.portal.util.RabbitMQUtil;
import cn.cjli.webmall.portal.vo.BuyerLoginVO;
import cn.cjli.webmall.portal.vo.SellerLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * webmall cn.cjli.webmall.portal.service.impl
 *
 * @author Lichaojie
 * @version 2019/6/3 14:12
 */
@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	private BuyerRepository buyerRepository;
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private RabbitMQUtil rabbitMQUtil;

	@Override
	public CommonResult doRegister(String username, String password, String role) {
		if (role != null && role.equals(RoleType.BUYER.getValue())){
			Buyer buyer = new Buyer();
			buyer.setUsername(username);
			buyer.setPassword(password);
			buyer.setCreateTime(new Date());
			if(buyerRepository.save(buyer) != null){
				rabbitMQUtil.sendMessage(QueueType.BUYER_NOTIFY.getValue(), buyer);
				return CommonResult.success();
			}
		}else if (role != null && role.equals(RoleType.SELLER.getValue())){
			Seller seller = new Seller();
			seller.setUsername(username);
			seller.setPassword(password);
			seller.setShop(username + "'s shop");
			seller.setCreateTime(new Date());
			if(sellerRepository.save(seller) != null){
				rabbitMQUtil.sendMessage(QueueType.SELLER_NOTIFY.getValue(), seller);
				return CommonResult.success();
			}
		}
		return CommonResult.failed();
	}

	@Override
	public CommonResult resetPassword(String username, String password, String role) {
		if (role != null && role.equals(RoleType.BUYER.getValue())){
			if(buyerRepository.update(username,password) == 0){
				return CommonResult.failed("更新失败");
			}
		}else if (role != null && role.equals(RoleType.SELLER.getValue())){
			if(sellerRepository.update(username, password) == 0){
				return CommonResult.failed("更新失败");
			}
		}
		return CommonResult.success();
	}

	@Override
	public CommonResult passwordLogin(String username, String password, String role) {
		if (role != null && role.equals(RoleType.BUYER.getValue())){
			Buyer buyer = buyerRepository.getByUsername(username);
			if (password != null && password.equals(buyer.getPassword())){
				BuyerLoginVO buyerLoginVO = new BuyerLoginVO();
				buyerLoginVO.setBuyerId(buyer.getBuyerId());
				buyerLoginVO.setUsername(buyer.getUsername());
				return CommonResult.success(buyerLoginVO);
			}
		}else if (role != null && role.equals(RoleType.SELLER.getValue())){
			Seller seller = sellerRepository.getByUsername(username);
			if (password != null && password.equals(seller.getPassword())){
				SellerLoginVO sellerLoginVO = new SellerLoginVO();
				sellerLoginVO.setSellerId(seller.getSellerId());
				sellerLoginVO.setUsername(seller.getUsername());
				return CommonResult.success(sellerLoginVO);
			}
		}
		return CommonResult.failed();
	}

	@Override
	public CommonResult smscodeLogin(String username, String role) {
		if (role != null && role.equals(RoleType.BUYER.getValue())){
			Buyer buyer = buyerRepository.getByUsername(username);
			if (buyer != null){
				BuyerLoginVO buyerLoginVO = new BuyerLoginVO();
				buyerLoginVO.setBuyerId(buyer.getBuyerId());
				buyerLoginVO.setUsername(buyer.getUsername());
				return CommonResult.success(buyerLoginVO);
			}
		}else if (role != null && role.equals(RoleType.SELLER.getValue())){
			Seller seller = sellerRepository.getByUsername(username);
			if (seller != null){
				SellerLoginVO sellerLoginVO = new SellerLoginVO();
				sellerLoginVO.setSellerId(seller.getSellerId());
				sellerLoginVO.setUsername(seller.getUsername());
				return CommonResult.success(sellerLoginVO);
			}
		}
		return CommonResult.failed();
	}
}

package cn.cjli.webmall.portal.service.impl;

import cn.cjli.webmall.data.entity.Commodity;
import cn.cjli.webmall.data.entity.Seller;
import cn.cjli.webmall.data.repository.CommodityRepository;
import cn.cjli.webmall.data.repository.SellerRepository;
import cn.cjli.webmall.portal.ro.CommodityAddRO;
import cn.cjli.webmall.portal.ro.CommodityUpdateRO;
import cn.cjli.webmall.portal.service.CommodityService;
import cn.cjli.webmall.portal.vo.BuyerCommodityDetailVO;
import cn.cjli.webmall.portal.vo.SellerCommodityDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * webmall cn.cjli.webmall.portal.service.impl
 *
 * @author Lichaojie
 * @version 2019/6/3 16:26
 */
@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityRepository commodityRepository;
	@Autowired
	private SellerRepository sellerRepository;

	@Override
	public Page<Commodity> showCommodityList(int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "commodityId");
		return commodityRepository.findCommoditiesByDeleted(pageable, false);
	}

	@Override
	public BuyerCommodityDetailVO getBuyerCommodityDetail(long commodityId) {
		Commodity commodity = commodityRepository.getByCommodityIdAndDeleted(commodityId,false);
		BuyerCommodityDetailVO commodityDetailVO = new BuyerCommodityDetailVO();
		if (commodity == null) return commodityDetailVO;
		Seller seller = sellerRepository.getOne(commodity.getSellerId());
		commodityDetailVO.setCommodityId(commodity.getCommodityId());
		commodityDetailVO.setName(commodity.getName());
		commodityDetailVO.setPicture(commodity.getPicture());
		commodityDetailVO.setDescription(commodity.getDescription());
		commodityDetailVO.setPrice(commodity.getPrice());
		commodityDetailVO.setQuantity(commodity.getQuantity());
		commodityDetailVO.setSellerId(commodity.getSellerId());
		commodityDetailVO.setShop(seller.getShop());
		return commodityDetailVO;
	}

	@Override
	public SellerCommodityDetailVO getSellerCommodityDetail(long commodityId) {
		Commodity commodity = commodityRepository.getByCommodityIdAndDeleted(commodityId,false);
		SellerCommodityDetailVO sellerCommodityDetailVO = new SellerCommodityDetailVO();
		if (commodity == null) return sellerCommodityDetailVO;
		sellerCommodityDetailVO.setCommodityId(commodity.getCommodityId());
		sellerCommodityDetailVO.setName(commodity.getName());
		sellerCommodityDetailVO.setPicture(commodity.getPicture());
		sellerCommodityDetailVO.setDescription(commodity.getDescription());
		sellerCommodityDetailVO.setPrice(commodity.getPrice());
		sellerCommodityDetailVO.setQuantity(commodity.getQuantity());
		return sellerCommodityDetailVO;
	}

	@Override
	public Commodity addCommodity(CommodityAddRO commodityAddRO) {
		Commodity commodity = new Commodity();
		commodity.setDeleted(false);
		commodity.setName(commodityAddRO.getName());
		commodity.setPicture(commodityAddRO.getPicture());
		commodity.setDescription(commodityAddRO.getDescription());
		commodity.setPrice(commodityAddRO.getPrice());
		commodity.setQuantity(commodityAddRO.getQuantity());
		commodity.setSellerId(commodityAddRO.getSellerId());
		return commodityRepository.save(commodity);
	}

	@Override
	public int updateCommodity(CommodityUpdateRO commodityUpdateRO) {
		return commodityRepository.updateCommodity(commodityUpdateRO.getCommodityId(),
				commodityUpdateRO.getName(),
				commodityUpdateRO.getPicture(),
				commodityUpdateRO.getDescription(),
				commodityUpdateRO.getQuantity(),
				commodityUpdateRO.getPrice());
	}

	@Override
	public void deleteCommodity(long commodityId) {
		commodityRepository.logicallyDelete(commodityId);
	}

	@Override
	public Page<Commodity> showCommoditiesOfShop(long sellerId, int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "commodityId");
		return commodityRepository.findCommoditiesBySellerIdAndDeleted(pageable,sellerId, false);
	}
}

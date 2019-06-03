package cn.cjli.webmall.portal.service;

import cn.cjli.webmall.data.entity.Commodity;
import cn.cjli.webmall.portal.ro.CommodityAddRO;
import cn.cjli.webmall.portal.ro.CommodityUpdateRO;
import cn.cjli.webmall.portal.vo.BuyerCommodityDetailVO;
import cn.cjli.webmall.portal.vo.SellerCommodityDetailVO;
import org.springframework.data.domain.Page;

/**
 * webmall cn.cjli.webmall.portal.service
 *
 * @author Lichaojie
 * @version 2019/6/3 16:24
 */
public interface CommodityService {
	Page<Commodity> showCommodityList(int page, int size);

	BuyerCommodityDetailVO getBuyerCommodityDetail(long commodityId);

	SellerCommodityDetailVO getSellerCommodityDetail(long commodityId);

	Commodity addCommodity(CommodityAddRO commodityAddRO);

	int updateCommodity(CommodityUpdateRO commodityUpdateRO);

	void deleteCommodity(long commodityId);

	Page<Commodity> showCommoditiesOfShop(long sellerId, int page, int size);
}

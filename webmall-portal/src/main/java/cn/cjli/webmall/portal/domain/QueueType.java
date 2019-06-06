package cn.cjli.webmall.portal.domain;


/**
 * WebMall cn.cjli.webmall.portal.domain
 *
 * @author lichaojie
 * @version 2019-06-06 16:54
 */
public enum QueueType {

    BUYER_NOTIFY("buyerNotify"),
    SELLER_NOTIFY("sellerNotify");


    private String value;

    private QueueType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public QueueType setValue(String value) {
        this.value = value;
        return this;
    }
}

package com.spider.processor.priceProcessor;

import lombok.Data;
import us.codecraft.webmagic.Spider;

/**
 * @ClassName: getJDPrice
 * @Description: TODO
 * @author: zjh
 * @date: 2022/8/18  13:17
 * @Version: 1.0
 */
@Data
public class GetJDPrice implements GetPrice {
    private JDPriceProcessor spider;

    @Override
    public String getPrice(String product_id) {
        String url = "https://p.3.cn/prices/mgets?skuIds=J_"+product_id;
        spider = new JDPriceProcessor();
        System.out.println(spider);
        Spider.create(spider)
                .addUrl(url)
                .run(); // 执行爬虫
        return spider.getPriceInfo().getP();
    }
}

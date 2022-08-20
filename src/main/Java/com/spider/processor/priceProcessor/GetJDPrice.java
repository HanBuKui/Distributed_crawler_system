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
    private JDPriceProcessor processor;

    @Override
    public String getPrice(String product_id) {
        String url = "https://p.3.cn/prices/mgets?skuIds=J_"+product_id;
        processor = new JDPriceProcessor();
        Spider.create(processor)
                .addUrl(url)
                .run(); // 执行爬虫
        return processor.getPriceInfo().getP();
    }
}

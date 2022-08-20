package com.spider.processor.itemProcessor;


import lombok.Data;
import lombok.NoArgsConstructor;
import us.codecraft.webmagic.Spider;

/**
 * @ClassName: GetJDItem
 * @Description: TODO
 * @author: zjh
 * @date: 2022/8/20  17:24
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class GetJDItem implements GetItem{
    private JDItemProcessor processor;

    @Override
    public String getItemInfo(String productUrl) {
        processor = new JDItemProcessor();
        Spider.create(processor)
                .addUrl(productUrl)
                .run();
        return processor.getSkuName();
    }
}

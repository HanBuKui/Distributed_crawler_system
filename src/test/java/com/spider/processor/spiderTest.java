package com.spider.processor;

import com.spider.processor.itemProcessor.JDItemProcessor;
import com.spider.processor.priceProcessor.GetJDPrice;
import com.spider.processor.priceProcessor.GetPrice;
import com.spider.processor.priceProcessor.JDPriceProcessor;
import com.spider.processor.searchProcessor.JDSearchProcessor;
import org.junit.Test;
import sun.security.provider.ConfigFile;
import us.codecraft.webmagic.Spider;

/**
 * @ClassName: spiderTest
 * @Description: TODO
 * @author: zjh
 * @date: 2022/8/18  12:32
 * @Version: 1.0
 */
public class spiderTest {
    @Test
    public void testGetPriceSpider() {
        String url = "https://p.3.cn/prices/mgets?skuIds=J_100016931023";
        Spider.create(new JDPriceProcessor())
                .addUrl(url)
                .run(); // 执行爬虫
    }

    @Test
    public void testGetJDPricer() {
        GetPrice node = new GetJDPrice();
        System.out.println(node.getPrice("100016931023"));
    }

    /**
     * @Description: 测试获取单个商品的信息
     * @Param: []
     * @return: void
     */
    @Test
    public void testGetItemInfo() {
        /*
        spu: 100016931023
        sku: 100016931001
         */
        Spider.create(new JDItemProcessor())
                //初始访问url地址
                .addUrl("https://item.jd.com/100016931001.html")
                .run(); // 执行爬虫
    }

    @Test
    public void testSearch(){
        String url = "https://search.jd.com/search?keyword=%E6%89%8B%E6%9C%BA&suggest=1.his.0.0&wq=%E6%89%8B%E6%9C%BA&ev=5_187852%5E&page=3";
        Spider .create(new JDSearchProcessor())
                .addUrl(url)
                .run();
    }


}

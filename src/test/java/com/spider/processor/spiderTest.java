package com.spider.processor;

import com.spider.processor.priceProcessor.GetJDPrice;
import com.spider.processor.priceProcessor.GetPrice;
import com.spider.processor.priceProcessor.JDPriceProcessor;
import org.junit.Test;
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
    public void testGetPriceSpider(){
        String url = "https://p.3.cn/prices/mgets?skuIds=J_100016931023";
        Spider.create(new JDPriceProcessor())
                .addUrl(url)
                .run(); // 执行爬虫
    }

    @Test
    public void testGetJDPricer(){
        GetPrice node = new GetJDPrice();
        System.out.println(node.getPrice("100016931023"));
    }

    /**
    *@Description: 测试获取sku的信息
    *@Param: []
    *@return: void
    */
    @Test
    public void testGetItemInfo(){
        
    }
    
    
}

package com.spider.processor;

import com.spider.client.JDItemClient;
import com.spider.client.JDSearchClient;
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


    /**
    *@Description: 第一步爬取搜索页面  目前只执行第一页的爬取
    *@Param: []
    *@return: void
    */
    @Test
    public void testSearchClient(){
        JDSearchClient searchClient = new JDSearchClient();
        searchClient.getInfoBySearch("手机");
    }


    /**
     *@Description: 第二步，根据调度系统爬取详细页面
     *@Param: []
     *@return: void
     */
    @Test
    public void testItemClient(){
        //执行testSearchClient得到的json   经调度系统调度到此节点
        String json = "{\"pic\":\"https://img13.360buyimg.com/n7/jfs/t1/219583/26/7800/151098/61b8a3f2E2879c4f6/9b73c1d24e0abecb.jpg\",\"sku\":\"100016931023\",\"spu\":\"100016931023\",\"url\":\"https://item.jd.com/100016931023.html\"}";
        JDItemClient jdItemClient = new JDItemClient();
        jdItemClient.getInfoByItem(json);
    }


    
    
    
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

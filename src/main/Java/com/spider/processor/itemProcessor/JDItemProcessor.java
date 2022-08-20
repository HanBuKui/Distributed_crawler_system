package com.spider.processor.itemProcessor;

import com.spider.entity.Item;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @ClassName: JDPageProcessor
 * @Description: 京东的PageProcessor功能实现
 * @author: zjh
 * @date: 2022/8/18  11:28
 * @Version: 1.0
 */
public class JDItemProcessor implements PageProcessor {
    /*
    商品信息实体
     */
    private Item item;

    /**
    *重试次数为3次，抓取间隔为一秒
    */
    private Site site = Site
            .me()
            .setRetryTimes(3)
            .setSleepTime(1000)
            .setCharset("utf-8")
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");;

    @Override
    /**
    *@Description: process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    *@Param: [page]
    *@return: void
    */
    public void process(Page page) {
        System.out.println(page.getHtml().toString());
//        page.putField();
        // css表达式
        page.putField("title", page.getHtml().toString());
        page.putField("title", page.getHtml());
//        Spider.create
//        price_url = “https://p.3.cn/prices/mgets?skuIds=J_”+product_id
//        System.out.println("product sku-name is "+page.getResultItems().get("title"));
    }

    @Override
    public Site getSite() {
        return site;
    }


}

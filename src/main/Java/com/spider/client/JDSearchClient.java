package com.spider.client;

import com.spider.processor.searchProcessor.JDSearchProcessor;
import us.codecraft.webmagic.Spider;

/**
 * @ClassName: JDSearchClient
 * @Description: TODO
 * @author: zjh
 * @date: 2022/8/20  18:32
 * @Version: 1.0
 */
public class JDSearchClient {
    /**
    *@Description: 根据关键词进行搜索页爬取
    *@Param: [keyword]
    *@return: void
    */
    public void getInfoBySearch(String keyword){
        String basicUrl = "https://search.jd.com/Search?enc=utf-8&keyword="+keyword;
        String page = "&page=";
        //进行页数循环
        String url = basicUrl+page+"1";
        Spider.create(new JDSearchProcessor())
                .addUrl(url)
                .run();
    }
}

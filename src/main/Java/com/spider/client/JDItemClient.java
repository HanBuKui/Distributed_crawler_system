package com.spider.client;

import com.alibaba.fastjson.JSON;
import com.spider.entity.Item;
import com.spider.entity.SearchItemInfo;
import com.spider.processor.itemProcessor.GetItem;
import com.spider.processor.itemProcessor.GetJDItem;
import com.spider.processor.priceProcessor.GetJDPrice;
import com.spider.processor.priceProcessor.GetPrice;
import jdk.nashorn.internal.scripts.JD;

/**
 * @ClassName: ItemClient
 * @Description: TODO
 * @author: zjh
 * @date: 2022/8/20  17:31
 * @Version: 1.0
 */
public class JDItemClient {

    GetItem itemspider = new GetJDItem();
    GetPrice priceSpider = new GetJDPrice();

    /**
    *@Description: 根据调度获得的json信息进一步执行爬虫，获取信息
    *@Param: [searchItemInfo]
    *@return: void
    */
    public void getInfoByItem(String searchItemInfo){
        SearchItemInfo info = JSON.parseObject(searchItemInfo, SearchItemInfo.class);
        Item item = new Item(info);
        item.setTitle(itemspider.getItemInfo(item.getUrl()));
        item.setPrice(Double.parseDouble(priceSpider.getPrice(item.getSku())));
        System.out.println("爬取信息如下："+item);
    }
}

package com.spider.processor.priceProcessor;

import com.alibaba.fastjson.JSON;
import com.spider.entity.JDPriceInfo;
import lombok.Data;
import lombok.SneakyThrows;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * @ClassName: getJDPrice
 * @Description: TODO
 * @author: zjh
 * @date: 2022/8/18  12:16
 * @Version: 1.0
 */
@Data
public class JDPriceProcessor implements PageProcessor {

    /**
    *价钱信息
    */
    private JDPriceInfo priceInfo;

    private Site site = Site
            .me()
            .setRetryTimes(3)
            .setSleepTime(1000)
            .setCharset("utf-8")
            .setUserAgent(
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36");

    @SneakyThrows
    @Override
    public void process(Page page) {
//        System.out.println(page.getHtml().toString());
        page.putField("JD_productPrice", page.getHtml().$("body","text"));
        if (page.getResultItems().get("JD_productPrice") == null) {
            //skip this page
            page.setSkip(true);
            throw new Exception("获取商品价格失败！");
        }else {
            String priceJson = page.getResultItems().get("JD_productPrice").toString().trim();
            List<JDPriceInfo> jdPriceInfos = JSON.parseArray(priceJson, JDPriceInfo.class);
            priceInfo = jdPriceInfos.get(0);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

}

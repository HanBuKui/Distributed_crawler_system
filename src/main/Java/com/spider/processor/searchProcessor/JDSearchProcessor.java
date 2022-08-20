package com.spider.processor.searchProcessor;

import com.alibaba.fastjson.JSON;
import com.spider.entity.SearchItemInfo;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

/**
 * @ClassName: JDSearchProcessor
 * @Description: TODO
 * @author: zjh
 * @date: 2022/8/20  14:55
 * @Version: 1.0
 */
public class JDSearchProcessor implements PageProcessor {
    private Site site = Site
            .me()
            .setRetryTimes(3)
            .setSleepTime(1000)
            .setCharset("utf-8")
            .setUserAgent(
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36");

    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        //获取本页所有商品信息 li
        List<String> text = html.$("div#J_goodsList > ul > li").all();
        for (String items : text){
            //一条商品信息（li）
            Html oneItem = new Html(items);
            //获取spu
            String spu = oneItem.$(".gl-item","data-spu").toString();
//            System.out.println("spu is "+spu);
            //获取一系列sku  找到li里面的class = “ps-item”
            List<String> skus = oneItem.$("li .ps-item").all();
            for (String s:skus){
                Html psItem = new Html(s);
                //获取sku
                String sku = psItem.$("img", "data-sku").toString();

                String picurlAfter = psItem.$("img", "data-lazy-img").toString();
                if("".equals(picurlAfter) || picurlAfter == null){
                    picurlAfter = psItem.$("img", "data-lazy-img-slave").toString();
                }
                //获取商品图片
                String pic = "https:"+picurlAfter;
                //详细页面的url
                String url = "https://item.jd.com/"+sku+".html";
                SearchItemInfo searchItemInfo = new SearchItemInfo(spu,sku,pic,url);
                /*
                将该信息交给调度系统（开始）
                 */
                String jsonInfo = JSON.toJSONString(searchItemInfo);
                //提交
                //此处以输出代替
                System.out.println(jsonInfo);
                /*
                将该信息交给调度系统（结束）
                 */
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}

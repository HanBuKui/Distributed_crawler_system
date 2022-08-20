package com.spider.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: Item
 * @Description: 京东商品信息
 * @author: zjh
 * @date: 2022/8/18  17:37
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    /*
    商品集合id
     */
    private String spu;
    /*
    商品最小品类id
     */
    private String sku;
    /*
    商品标题
     */
    private String title;
    /*
    商品价格
     */
    private Double price;
    /*
    商品图片
     */
    private String pic;
    /*
    商品详细地址
     */
    private String url;
    /*
    创建时间
     */
    private Date createTime;

    public Item(SearchItemInfo info){
        this.spu = info.getSpu();
        this.sku = info.getSku();
        this.pic = info.getPic();
        this.url = info.getUrl();
        createTime = new Date();
    }

}

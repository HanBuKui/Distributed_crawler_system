package com.spider.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: SearchItemInfo
 * @Description: 从search页面读取的相关信息，交由调度系统进行调度
 * @author: zjh
 * @date: 2022/8/20  16:46
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchItemInfo implements Serializable {
    /*
    商品集合id
     */
    private String spu;
    /*
    商品最小品类id
     */
    private String sku;
    /*
    商品图片
     */
    private String pic;
    /*
    商品详细地址
     */
    private String url;
}

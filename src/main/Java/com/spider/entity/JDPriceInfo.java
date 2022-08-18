package com.spider.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: JDPriceInfo
 * @Description: TODO
 * @author: zjh
 * @date: 2022/8/18  12:44
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JDPriceInfo {
    /**
    * 目前价格
    */
    private String p;

    /**
     * 指导价
     */
    private String op;

    private String cbf;

    /**
     * 商品id
     */
    private String id;

    private String m;
}

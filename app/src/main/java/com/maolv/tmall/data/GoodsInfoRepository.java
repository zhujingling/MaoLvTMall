package com.maolv.tmall.data;

import com.maolv.tmall.bean.GoodInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhujingling on 16/5/15.
 */
public class GoodsInfoRepository {
    public static List<GoodInfo> getGoodInfoList() {
        List<GoodInfo> list = new ArrayList<GoodInfo>();
        for (int i = 0; i < 5; i++) {
            GoodInfo goodInfo = new GoodInfo();
            goodInfo.setImage("");
            goodInfo.setIntroductions("[掌柜推荐] 越南青芒5斤装(5-8个)");
            goodInfo.setSpecifications("规格5斤装(5-8个)");
            goodInfo.setFresh("新鲜上市");
            goodInfo.setPrices("¥ 69.90");
            list.add(goodInfo);
        }
        return list;
    }
}

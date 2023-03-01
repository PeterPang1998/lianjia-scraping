package org.pxy.pojo;

import lombok.Data;

@Data
public class Apartment {
    String name;
    String houseInfo;
    String followAndUpdateInfo;
    String tags;
    String price;

    @Override
    public String toString(){
        return String.
                format("地址{%s}｜\n描述{%s}｜\n更新信息{%s}｜\n标签{%s}｜\n价格{%s}\n",this.name,this.houseInfo,this.followAndUpdateInfo,this.tags,this.price);
    }
}

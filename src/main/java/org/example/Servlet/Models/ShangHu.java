package org.example.Servlet.Models;

import lombok.Data;

import java.util.List;

@Data
public class ShangHu {

    public ShangHu(String id, String name, Integer pingFen, List<String> caiPin, Integer pingJiaShu) {
        this.id = id;
        this.name = name;
        this.pingFen = pingFen;
        this.caiPin = caiPin;
        this.pingJiaShu = pingJiaShu;
    }

    private String id;

    //商户
    private String name;

    //评分
    private Integer pingFen;

    //菜品
    private List<String> caiPin;

    //评价数
    private Integer pingJiaShu;

    @Override
    public String toString() {
        return "ShangHu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pingFen=" + pingFen +
                ", caiPin=" + caiPin +
                ", pingJiaShu=" + pingJiaShu +
                '}';
    }
}

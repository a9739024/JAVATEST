package org.example.Servlet.Bo;

import org.example.Servlet.Services.IAdventurer;
import org.example.Servlet.Services.Impl.SimpleFactory.ArcherImpl;
import org.example.Servlet.Services.Impl.SimpleFactory.WarriorImpl;

/*
 * 簡單工廠模式:由一個工廠管理所有要生產的產品，用判斷式來區分產品類型
 */
public class TrainingCamp {

    public static IAdventurer trainAdventurer(String type){
        switch(type){
            case "archer" : {
                System.out.println("訓練一個弓箭手");
                return new ArcherImpl();
            }
            case "warrior": {
                System.out.println("訓練一個鬥士");
                return new WarriorImpl();
            }
            // 假如冒險者種類新增，增加case就可以
            default : return null;
        }
    }
}

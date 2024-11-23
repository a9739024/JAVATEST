package org.example.Servlet.Bo;

import org.example.Servlet.Services.IAdventurer;
import org.junit.Assert;
import org.junit.Test;

public class TrainingCampTest {

    @Test
    public void test(){
        //新手村訓練冒險者
        IAdventurer memberA = TrainingCamp.trainAdventurer("archer");
        IAdventurer memberB = TrainingCamp.trainAdventurer("warrior");
        //這邊用Junit來幫我們判斷訓練出來的冒險者是不是我們想要的
        Assert.assertEquals(memberA.getType(), "Archer");
        Assert.assertEquals(memberB.getType(), "Warrior");
    }
}
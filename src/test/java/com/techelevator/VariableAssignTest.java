package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariableAssignTest {



    @Test
    public void getterMethodTest(){
        BigDecimal firstresult = BigDecimal.valueOf(1.20);
       BigDecimal justForOne =  firstresult.setScale(2, RoundingMode.CEILING);

        VariableAssign testerForMe = new VariableAssign();
        testerForMe.setMachineBalance(1.20);
        Assert.assertEquals(justForOne,testerForMe.getMachineBalance());

    }


    @Test
    public void totalMethodTest() {
        BigDecimal secondresult = BigDecimal.valueOf(2.30);
        BigDecimal yeahhh = secondresult.setScale(2,RoundingMode.CEILING);
        VariableAssign testerForMe = new VariableAssign();
        double hi =2.30;
        testerForMe.setTotalSales(hi);



        Assert.assertEquals(yeahhh,testerForMe.getTotalSales().setScale(2,RoundingMode.CEILING));



    }

}

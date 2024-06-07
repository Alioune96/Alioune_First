package com.techelevator;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariableAssign {

    private boolean isOn = true;

    private BigDecimal totalSales = new BigDecimal(0.00);
    private BigDecimal machineBalance = new BigDecimal(0.00);

    public void setMachineBalance(double currentBalance) {
        BigDecimal element = new BigDecimal(currentBalance);
        this.machineBalance = element;
        this.machineBalance = this.machineBalance.setScale(2);
    }

    public BigDecimal getMachineBalance() {
        return machineBalance;
    }

    public void addMachineBalance(double machineBalance) {
        BigDecimal element = new BigDecimal(machineBalance);
        this.machineBalance = this.machineBalance.add(element);
        this.machineBalance = this.machineBalance.setScale(2, RoundingMode.CEILING);
    }
    public void minusMachineBalance(double machineBalance) {
        BigDecimal element = new BigDecimal(machineBalance);
        this.machineBalance = this.machineBalance.subtract(element);
        this.machineBalance = this.machineBalance.setScale(2, RoundingMode.CEILING);
    }



    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        this.isOn = on;
    }


    public void setTotalSales(double totalSales) {
        BigDecimal element = new BigDecimal(totalSales);
        this.totalSales = element;
    }

    public void addTotalSales(double totalSales) {
        BigDecimal element = new BigDecimal(totalSales);
        this.totalSales =  this.totalSales.add(element);
        this.totalSales = this.totalSales.setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }
}

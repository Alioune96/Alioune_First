package com.techelevator;


public class VariableAssign {

    private boolean isOn = true;
    private double machineBalance = 0;

    private double totalSales = 0;

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        this.isOn = on;
    }

    public double getMachineBalance() {
        return machineBalance;
    }

    public void addMachineBalance(double machineBalance) {
        this.machineBalance = this.machineBalance+machineBalance;
    }

    public void minusMachineBalance(double machineBalance) {
        this.machineBalance = this.machineBalance - machineBalance;
    }

    public void setMachineBalance(double machineBalance) {
        this.machineBalance = machineBalance;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public void addTotalSales(double totalSales) {
        this.totalSales =  this.totalSales + totalSales;
    }
}

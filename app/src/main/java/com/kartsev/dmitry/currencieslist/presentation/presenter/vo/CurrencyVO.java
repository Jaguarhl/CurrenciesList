package com.kartsev.dmitry.currencieslist.presentation.presenter.vo;

import java.text.DecimalFormat;

public class CurrencyVO {
    private String currencyName;
    private double currencyVolume;
    private int currencyAmount;

    public CurrencyVO(String currencyName, double currencyVolume, int currencyAmount) {
        this.currencyName = currencyName;
        this.currencyVolume = currencyVolume;
        this.currencyAmount = currencyAmount;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyVolume() {
        DecimalFormat precision = new DecimalFormat("0.00");
        return precision.format(currencyVolume);
    }

    public void setCurrencyVolume(double currencyVolume) {
        this.currencyVolume = currencyVolume;
    }

    public int getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(int currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    @Override
    public String toString() {
        return "CurrencyVO{" +
                "currencyName='" + currencyName + '\'' +
                ", currencyVolume=" + currencyVolume +
                ", currencyAmount=" + currencyAmount +
                "}\n";
    }
}

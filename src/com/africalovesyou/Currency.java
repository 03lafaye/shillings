package com.africalovesyou;

import android.graphics.drawable.Drawable;

import java.util.HashMap;

public class Currency {
    private Drawable mFlag;
    private String mName;
    private String mSymbol;
    private Integer[] mCoinDenominations;
    private Integer[] mPaperDenominations;
    private HashMap<Currency, Double> mConversionMap;

    public Currency(String name, String symbol, Drawable flag) {
        mName = name;
        mSymbol = symbol;
        mFlag = flag;
        mConversionMap = new HashMap<Currency, Double>();
    }

    public void setCoinDenominations(Integer[] denominations) {
        mCoinDenominations = denominations;
    }

    public Integer[] getCoinDenominations() {
        return mCoinDenominations;
    }

    public void setPaperDenominations(Integer[] denominations) {
        mPaperDenominations = denominations;
    }

    public Integer[] getPaperDenominations() {
        return mPaperDenominations;
    }

    public Integer[] getDenominations() {
        Integer[] allDenominations = new Integer[mCoinDenominations.length + mPaperDenominations.length];
        System.arraycopy(mCoinDenominations, 0, allDenominations, 0, mCoinDenominations.length);
        System.arraycopy(
                mPaperDenominations, 0, allDenominations, mCoinDenominations.length, mPaperDenominations.length);
        return allDenominations;
    }

    public double convert(Currency currency, double amount) {
        if (!mConversionMap.containsKey(currency))
            return 1;

        double rate = mConversionMap.get(currency);
        return amount * rate;
    }

    public void put(Currency currency, double rate) {
        mConversionMap.put(currency, rate);
    }

    public Drawable getFlag() {
        return mFlag;
    }

    public String getName() {
        return mName;
    }

    public String getSymbol() {
        return mSymbol;
    }

    public boolean isCoin(int amount) {
        for (Integer denomination : mCoinDenominations) {
            if (denomination == amount)
                return true;
        }
        return false;
    }
}

package com.africalovesyou;

import android.graphics.drawable.Drawable;

import java.util.HashMap;

public class Currency {
    private Drawable mFlag;
    private String mName;
    private String mSymbol;
    private HashMap<Currency, Double> mConversionMap;

    public Currency(String name, String symbol, Drawable flag) {
        mName = name;
        mSymbol = symbol;
        mFlag = flag;
        mConversionMap = new HashMap<Currency, Double>();
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
}

package com.africalovesyou;

import android.content.Context;

import java.util.Vector;

public class Denominations {
    private Currency mCurrentCurrency;
    private Currency mConversionCurrency;

    public static final int Dirham = 0;
    public static final int Dollar = 1;
    public static final int Shilling = 2;

    private Vector<Currency> mCurrencies;

    private static final Integer[] mDenominations = {
            1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 1200, 1500, 2000, 2100, 2500,
            3000, 3100, 3500, 4000, 4100, 4500, 5000, 5500, 6000, 6500, 7000,
            7500, 8000, 8500, 9000, 9500, 10000
    };

    private static final Integer[] mColours = {
            0xffffffff, 0xffe2bf6e, 0xff837a71, 0xffc8564c, 0xff70c7da, 0xffe46c30, 0xff65a970, 0xfffad256,
            0xffe562e0, 0xff7462e5, 0xff62e5b5, 0xffe56262, 0xffff2e4c, 0xff79fd9b, 0xff4d31f9, 0xffa98653 };

    private static Denominations INSTANCE;

    private Denominations(Context context) {
        mCurrencies = new Vector<Currency>(Shilling + 1);

        Currency aed = new Currency("United Arab Emirates Dirham", "Dh", context.getResources().getDrawable(R.drawable.ae));
        aed.setCoinDenominations(new Integer[] { 1 });
        aed.setPaperDenominations(new Integer[] { 5, 10, 20, 50, 100, 1000 });
        Currency cad = new Currency("Canadian Dollar", "$", context.getResources().getDrawable(R.drawable.ca));
        cad.setCoinDenominations(new Integer[] { 1, 2 });
        cad.setPaperDenominations(new Integer[] { 5, 10, 20, 50, 100, 1000 });
        Currency ksh = new Currency("Kenyan Shilling", "KSh", context.getResources().getDrawable(R.drawable.ke));
        ksh.setCoinDenominations(new Integer[] { 1, 5, 10 , 20, 40 });
        ksh.setPaperDenominations(new Integer[] { 50, 100, 200, 500, 1000 });

        mCurrencies.add(aed);
        mCurrencies.add(cad);
        mCurrencies.add(ksh);

        // TODO: Load from external conversion rate server instead of hard-coding.
        mCurrencies.get(Dirham).put(mCurrencies.get(Dollar), 0.2659);
        mCurrencies.get(Dirham).put(mCurrencies.get(Shilling), 23.0336);

        mCurrencies.get(Dollar).put(mCurrencies.get(Dirham), 3.7605);
        mCurrencies.get(Dollar).put(mCurrencies.get(Shilling), 86.6359);

        mCurrencies.get(Shilling).put(mCurrencies.get(Dirham), 0.0116);
        mCurrencies.get(Shilling).put(mCurrencies.get(Dollar), 0.0434);

        mCurrentCurrency = mCurrencies.get(Dollar);
        mConversionCurrency = mCurrencies.get(Dirham);
    }

    public static Denominations getInstance(Context context) {
        if (INSTANCE == null)
            INSTANCE = new Denominations(context);
        return INSTANCE;
    }

    public Currency getCurrentCurrency() {
        return mCurrentCurrency;
    }

    public void setCurrentCurrency(Currency currency) {
        mCurrentCurrency = currency;
    }

    public Currency getConversionCurrency() {
        return mConversionCurrency;
    }

    public void setConversionCurrency(Currency currency) {
        mConversionCurrency = currency;
    }

    public Vector<Currency> getCurrencies() {
        return mCurrencies;
    }

    public Integer[] getDenominations() {
        return mDenominations;
    }

    public Integer[] getColours() {
        return mColours;
    }
}

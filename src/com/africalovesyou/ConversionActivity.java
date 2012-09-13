package com.africalovesyou;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ConversionActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.main);
        loadDenominations();
    }

    private void loadDenominations() {
        Denominations denominations = Denominations.getInstance(this);
        ListView denominationsList = (ListView) findViewById(R.id.denominations);
        ArrayAdapter<Integer> mDenominationsAdapter = new ConversionArrayAdapter(
                this, R.layout.row, denominations.getDenominations());

        ImageView flag1 = (ImageView) findViewById(R.id.flag1);
        flag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Denominations denominations = Denominations.getInstance(view.getContext());

                for (Currency currency : denominations.getCurrencies()) {
                    if (currency != denominations.getConversionCurrency() &&
                            currency != denominations.getCurrentCurrency()) {
                        denominations.setCurrentCurrency(currency);
                        break;
                    }
                }
                loadDenominations();
            }
        });
        flag1.setImageDrawable(denominations.getCurrentCurrency().getFlag());
        ImageView flag2 = (ImageView) findViewById(R.id.flag2);
        flag2.setImageDrawable(denominations.getConversionCurrency().getFlag());
        flag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Denominations denominations = Denominations.getInstance(view.getContext());
                for (Currency currency : denominations.getCurrencies()) {
                    if (currency != denominations.getConversionCurrency() &&
                            currency != denominations.getCurrentCurrency()) {
                        denominations.setConversionCurrency(currency);
                        break;
                    }
                }
                loadDenominations();
            }
        });
        denominationsList.setAdapter(mDenominationsAdapter);
    }
}

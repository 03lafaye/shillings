package com.africalovesyou;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ConversionActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Denominations denominations =  Denominations.getInstance(this);

        setContentView(R.layout.main);

        ListView denominationsList = (ListView) findViewById(R.id.denominations);
        ArrayAdapter<Integer> mDenominationsAdapter = new ConversionArrayAdapter(
                this, R.layout.row, denominations.getDenominations());
        denominationsList.setAdapter(mDenominationsAdapter);
    }
}

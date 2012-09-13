package com.africalovesyou;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Vector;

public class CurrencyChangeDialog extends DialogFragment {

    public CurrencyChangeDialog() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog, container);

//        Vector<Currency> currencies = Denominations.getInstance(this).getDenominations();
//
//        ListView denominationsList = (ListView) findViewById(R.id.denominations);
//        ArrayAdapter<Currency> mDenominationsAdapter = new CurrencySelectorArrayAdapter(
//                this, R.layout.row, currencies);


        return view;
    }
}

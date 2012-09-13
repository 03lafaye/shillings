package com.africalovesyou;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ConversionArrayAdapter extends ArrayAdapter<Integer> {
    private Context mContext;
    private Denominations mDenominations;
    DecimalFormat mDecimalFormat = new DecimalFormat("####.##");

    public ConversionArrayAdapter(Context context, int textViewResourceId, Integer[] objects) {
        super(context, textViewResourceId, objects);
        mDenominations = Denominations.getInstance(context);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row, null);
        }

        Currency current = mDenominations.getCurrentCurrency();
        Currency conversion = mDenominations.getConversionCurrency();

        int amount = getItem(position);

        if (current.isCoin(amount)) {
            View currentCurrency = convertView.findViewById(R.id.currentCurrency);
            currentCurrency.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.border_circle));
        }

        TextView amount1 = (TextView)convertView.findViewById(R.id.amount1);
        amount1.setText(mDecimalFormat.format(amount));
        TextView amount2 = (TextView)convertView.findViewById(R.id.amount2);
        amount2.setText(mDecimalFormat.format(current.convert(conversion, amount)));
        TextView symbol1 = (TextView)convertView.findViewById(R.id.symbol1);
        symbol1.setText(current.getSymbol());
        TextView symbol2 = (TextView)convertView.findViewById(R.id.symbol2);
        symbol2.setText(conversion.getSymbol());

        Integer[] colours = mDenominations.getColours();
        int colour = colours[position % colours.length];
        convertView.setBackgroundColor(colour);

        return convertView;
    }
}

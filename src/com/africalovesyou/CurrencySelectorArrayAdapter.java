package com.africalovesyou;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

public class CurrencySelectorArrayAdapter extends ArrayAdapter<Currency> {
    private Context mContext;

    public CurrencySelectorArrayAdapter(
            Context context, int textViewResourceId, Currency[] objects, boolean isCurrent) {
        super(context, textViewResourceId, objects);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dialog_row, null);
        }
        Currency c = getItem(position);
        ImageView flag = (ImageView) convertView.findViewById(R.id.flag);
        flag.setImageDrawable(c.getFlag());
        TextView name = (TextView) convertView.findViewById(R.id.name);
        name.setText(c.getName() + "(" + c.getSymbol() + ")");

        return convertView;
    }
}

package br.com.brasilcardfacil.www.brasilcardfacil.controller.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.brasilcardfacil.www.brasilcardfacil.R;

public class MySpinnerAdapter extends ArrayAdapter<String> {
    // Initialise custom font, for example:
    private Typeface font = Typeface.createFromAsset(getContext().getAssets(),
            "fonts/futura_medium_bt-webfont.ttf");

    // (In reality I used a manager which caches the Typeface objects)
    // Typeface font = FontManager.getInstance().getFont(getContext(), BLAMBOT);

    public MySpinnerAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
    }

    // Affects default (closed) state of the spinner
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        view.setTypeface(font);
        view.setTextColor(getContext().getResources().getColor(R.color.grey));
        return view;
    }

    // Affects opened state of the spinner
    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        TextView view = (TextView) super.getDropDownView(position, convertView, parent);
        view.setTypeface(font);
        view.setTextColor(getContext().getResources().getColor(R.color.grey));
        return view;
    }
}

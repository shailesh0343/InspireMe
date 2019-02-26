package io.traitsoft.inspireme.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.traitsoft.inspireme.Quote;
import io.traitsoft.inspireme.R;

public class QuoteAdapter extends ArrayAdapter<Quote> {

    private Context mContext;
    int mResource;

    public QuoteAdapter(Context context, int resource, ArrayList<Quote> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String quote = getItem(position).getQuote();
        String writer = getItem(position).getWriter();

        Quote quoteObj = new Quote();
        LayoutInflater inflater = LayoutInflater.from(mContext);

        convertView = inflater.inflate(mResource,parent,false);

        TextView tvQuote = convertView.findViewById(R.id.list_text1);
        TextView tvPeople = convertView.findViewById(R.id.list_text2);

        tvQuote.setText(quote);
        tvPeople.setText(writer);

        return convertView;

    }
}

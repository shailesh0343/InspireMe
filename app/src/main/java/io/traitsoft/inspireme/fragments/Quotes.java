package io.traitsoft.inspireme.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import io.traitsoft.inspireme.DatabaseAccess;
import io.traitsoft.inspireme.Quote;
import io.traitsoft.inspireme.R;
import io.traitsoft.inspireme.adapters.QuoteAdapter;

public class Quotes extends Fragment {

    private static final String TAG = "myApp";
    private ArrayList<Quote> quoteList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_quotes, container, false);

        DatabaseAccess databaseAccess = new DatabaseAccess();
        ListView quoteListView = rootview.findViewById(R.id.quotes_list);
        quoteList = databaseAccess.getQuoteList();
       // Log.v(TAG, quoteList.get(1).getQuote());

        QuoteAdapter adapter = new QuoteAdapter(getContext(),R.layout.row, quoteList);
        quoteListView.setAdapter(adapter);
        return rootview;
    }

}



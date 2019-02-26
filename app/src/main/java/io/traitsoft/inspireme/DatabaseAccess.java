package io.traitsoft.inspireme;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DatabaseAccess {

    private DatabaseReference mDatabase;
    private ArrayList<Quote> quoteList;
    private static final String TAG = "myApp";


    public DatabaseAccess() {

        mDatabase = FirebaseDatabase.getInstance().getReference().child("quotedb");
    }


    public ArrayList<Quote> getQuoteList() {
        quoteList= new ArrayList<>();
        //DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("alarm_list");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    for (DataSnapshot quoteSnapshot : dataSnapshot.getChildren()) {
                        Quote quote= quoteSnapshot.getValue(Quote.class);
                        quoteList.add(quote);


                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


                Log.v(TAG, quoteList.get(1).getQuote());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Log.w(TAG, "Error: ", databaseError.toException());
            }
        });

        //Log.v(TAG, quoteList.get(0).getWriter());

        return quoteList;
    }
}


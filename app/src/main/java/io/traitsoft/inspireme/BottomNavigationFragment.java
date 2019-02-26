package io.traitsoft.inspireme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import io.traitsoft.inspireme.fragments.Favorites;
import io.traitsoft.inspireme.fragments.Peoples;
import io.traitsoft.inspireme.fragments.Qofday;
import io.traitsoft.inspireme.fragments.Quotes;

public class BottomNavigationFragment extends BottomSheetDialogFragment {


    NavigationView navigationView;

    public BottomNavigationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview = inflater.inflate(R.layout.fragment_bottomsheet, container, false);
        navigationView = rootview.findViewById(R.id.bottom_navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Fragment fragment = null;
                switch (id){

                    case R.id.nav1:
                        fragment = new Quotes();
                        displaySelectedFragment(fragment);
                        Toast.makeText(getContext(),"Clicked 1",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav2:
                        fragment = new Peoples();
                        displaySelectedFragment(fragment);
                        Toast.makeText(getContext(),"Clicked 2",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav3:
                        fragment = new Qofday();
                        displaySelectedFragment(fragment);
                        Toast.makeText(getContext(),"Clicked 3",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav4:
                        fragment = new Favorites();
                        displaySelectedFragment(fragment);
                        Toast.makeText(getContext(),"Clicked 4",Toast.LENGTH_SHORT).show();
                        return true;

                }
                return true;
            }
        });

        return rootview;
    }


    public void displaySelectedFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
        dismiss();
    }
}

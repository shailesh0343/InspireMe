package io.traitsoft.inspireme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import io.traitsoft.inspireme.fragments.Qofday;
import io.traitsoft.inspireme.fragments.Quotes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

public class MainActivity extends AppCompatActivity {

    BottomAppBar bottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomAppBar = findViewById(R.id.bottom_appbar);
        setSupportActionBar(bottomAppBar);

        launchQuotesFragment();
    }

    private void launchQuotesFragment() {
        Fragment fragment = new Quotes();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.bottom_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.setting_mn:
                Toast.makeText(this, "Clicked Settings",Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
                BottomNavigationFragment bottomNavigationFragment =new BottomNavigationFragment();
                bottomNavigationFragment.show(getSupportFragmentManager(), bottomNavigationFragment.getTag());
        }
        return true;
    }
}

package assignment.com.earthquakemonitor.UI.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import assignment.com.earthquakemonitor.R;
import assignment.com.earthquakemonitor.UI.Fragment.MapFragment;
import assignment.com.earthquakemonitor.UI.Fragment.SettingsFragment;
import assignment.com.earthquakemonitor.UI.Fragment.SummaryFragment;

public class MainActivity extends AppCompatActivity {

    final Fragment summaryFragment = SummaryFragment.getInstance();
    final Fragment mapFragment = MapFragment.getInstance();
    final Fragment settingsFragment = SettingsFragment.getInstance();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_summary:
                    loadFragment(summaryFragment);
                    setTitle("Summary");
                    return true;
                case R.id.navigation_map:
                    loadFragment(mapFragment);
                    setTitle("Map");
                    return true;
                case R.id.navigation_settings:
                    loadFragment(settingsFragment);
                    setTitle("Settings");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navigation.setSelectedItemId(R.id.navigation_summary);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private void setTitle(String title) {

        getSupportActionBar().setTitle(title);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== R.id.action_refresh) {
            ((SummaryFragment)summaryFragment).refreshData();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}

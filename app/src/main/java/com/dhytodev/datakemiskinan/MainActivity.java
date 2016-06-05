package com.dhytodev.datakemiskinan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.dhytodev.datakemiskinan.adapter.FragmentDrawer;
import com.dhytodev.datakemiskinan.fragment.AboutFragment;
import com.dhytodev.datakemiskinan.fragment.DataFragment;
import com.dhytodev.datakemiskinan.fragment.HomeFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    @Bind(R.id.title)
    TextView titleText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        // display the first navigation drawer view on app launch
        displayView(0);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String titleTxt = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                titleTxt = "Beranda";
                break;
            case 1:
                fragment = new DataFragment();
                titleTxt = "Data Kemiskinan" ;
                //Intent i = new Intent(getApplicationContext(), DataActivity.class);
                //startActivity(i);
                //finish();
                break;
            case 2:
                //fragment = new MapsFragment();
                //titleTxt = "Peta";

                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(i);
                break;
            case 3:
                fragment = new AboutFragment();
                titleTxt = "Tentang" ;
                break;
            case 4:
                //fragment = new FragmentAbout();
                //title = getString(R.string.title_about);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            //getSupportActionBar().setTitle(title);
            titleText.setText(titleTxt);
        }
    }
}


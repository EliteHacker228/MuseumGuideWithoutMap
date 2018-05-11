package com.example.max.mainwindow;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Boolean newsShowed, museumsShowed;

    NewsParserFragment newsFragment = new NewsParserFragment();
    ListFragment listFragment = new ListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if(savedInstanceState == null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().add(R.id.placeholder, newsFragment).commit();
        }


    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fragmentManager = getFragmentManager();
            //NewsParserFragment newsParserFragment = new NewsParserFragment();


            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_news:
                    Log.d("BottomNavigationBar", "Новости");

                            //FragmentManager fragment1Manager = getFragmentManager();
                            //NewsParserFragment newsFragment = new NewsParserFragment();
                            //fragment1Manager.beginTransaction().add(R.id.placeholder, newsFragment).commit();
                    transaction.replace(R.id.placeholder, newsFragment).show(newsFragment);
                    transaction.commit();

                    return true;
                case R.id.navigation_museums:
                    Log.d("BottomNavigationBar", "Музеи");

                    transaction.replace(R.id.placeholder, listFragment).show(listFragment);
                    transaction.commit();
                    return true;

                case R.id.navigation_map:
                    Log.d("BottomNavigationBar", "Карта");
                    return true;
            }
            return false;
        }
    };
}

package com.example.max.mainwindow;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.max.mainwindow.museumpackage.ListFragment;
import com.example.max.mainwindow.newslistpackage.NewsParserFragment;

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
            setTitle("Новости от Znak.com");
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


                            //FragmentManager fragment1Manager = getFragmentManager();
                            //NewsParserFragment newsFragment = new NewsParserFragment();
                            //fragment1Manager.beginTransaction().add(R.id.placeholder, newsFragment).commit();
                    transaction.replace(R.id.placeholder, newsFragment).show(newsFragment);
                    transaction.commit();
                    setTitle("Новости от Znak.com");
                    return true;
                case R.id.navigation_museums:


                    transaction.replace(R.id.placeholder, listFragment).show(listFragment);
                    transaction.commit();
                    setTitle("Музеи Екатеринбурга");
                    return true;

                case R.id.navigation_map:
                    setTitle("Карта музеев");
                    return true;
            }
            return false;
        }
    };
}

package com.example.besho.navigationapp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle ;
private Toolbar mToolbar;
    FragmentTransaction fragmentTransaction ;
    NavigationView navigationView ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar=(Toolbar)findViewById(R.id.nav_action) ;
        setSupportActionBar(mToolbar);
        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawerLayout);
         mToggle= new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView= (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override

            public boolean onNavigationItemSelected(MenuItem item){

                switch (item.getItemId()){
                    case R.id.nav_Home:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new home());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_MyRides:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new my_rides());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("My Rides");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        break;
                    case R.id.nav_wallet:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new wallet());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Wallet");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        break;
                    case R.id.nav_settings:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new settings());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Settings");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        break;
                    case R.id.nav_gethelp:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new get_help());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Get Help");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        break;


                }
                return true ;

            }
        });

    }

@Override
    public boolean onOptionsItemSelected(MenuItem item){
    if(mToggle.onOptionsItemSelected(item)){
    return true;
    }

    return super.onOptionsItemSelected(item);

}

}






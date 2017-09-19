package com.itechmandiri.myapplication.Activity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.itechmandiri.myapplication.Fragment.AboutFragment;
import com.itechmandiri.myapplication.Fragment.AccountFragment;
import com.itechmandiri.myapplication.Fragment.MenutUtamaFragment;
import com.itechmandiri.myapplication.Fragment.NotifFragment;
import com.itechmandiri.myapplication.R;
import com.itechmandiri.myapplication.Fragment.SettingFragment;

public class MainActivity extends AppCompatActivity {

    Intent Help;

    ActionBar actionBar ;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.content,new MenutUtamaFragment()).commit();
                    return true;
                case R.id.navigation_notifications:
                    transaction.replace(R.id.content,new NotifFragment()).commit();
                    return true;
                case R.id.navigation_about:
                    transaction.replace(R.id.content,new AboutFragment()).commit();
                    return true;
                case R.id.navigation_setting:
                    transaction.replace(R.id.content,new SettingFragment()).commit();
                    return true;
                case R.id.navigation_account:
                    transaction.replace(R.id.content,new AccountFragment()).commit();
                    return true;

            }
            return false;
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        getSupportActionBar().setLogo(R.drawable.coins);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content,new MenutUtamaFragment()).commit();
    }

    //Jika Tekan Tombol back
    public void onBackPressed() {
        keluarYN();//Pergi ke method exit
    }
    public void keluarYN(){
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Konfirmasi");

        ad.setMessage("Anda Yakin ingin keluar?");
        ad.setPositiveButton("IYA",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }});
        ad.setNegativeButton("TIDAK",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface arg0, int arg1) {
            }});
        ad.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_help:
                Intent myAplikasi1 = new Intent(this, com.itechmandiri.myapplication.Activity.Help.class);
                startActivity(myAplikasi1);
                return true;

            case R.id.navigation_exit:
            {
                keluarYN();//Pergi ke method exit
            }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

}

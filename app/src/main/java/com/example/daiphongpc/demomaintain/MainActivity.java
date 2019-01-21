package com.example.daiphongpc.demomaintain;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daiphongpc.demomaintain.Activity.AccountOtherActivity;
import com.example.daiphongpc.demomaintain.Model.Custommer;
import com.example.daiphongpc.demomaintain.fragment.AboutFragment;
import com.example.daiphongpc.demomaintain.fragment.AccessaryFragment;
import com.example.daiphongpc.demomaintain.fragment.HistoryFragment;
import com.example.daiphongpc.demomaintain.fragment.ServiceFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Spinner spOther;
    TextView txtNumber,txtBienSo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void addEvents() {
        List<String> categories = new ArrayList<String>();
        categories.add("");
        categories.add("Thêm tài khoản\n");
        categories.add("");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
 //       dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spOther.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)view).setText("");
                if (position>0){
                    Intent intent=new Intent(MainActivity.this,AccountOtherActivity.class);
                    startActivityForResult(intent,114);
                }
                spOther.setSelection(0);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spOther.setAdapter(dataAdapter);
    }

    private void addControls() {



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_service);

        View headerLayout =
                navigationView.inflateHeaderView(R.layout.nav_header_main);
        spOther=headerLayout.findViewById(R.id.sp_other);
        txtNumber=headerLayout.findViewById(R.id.txt_number);
        txtBienSo=headerLayout.findViewById(R.id.txt_bienso);

        ServiceFragment serviceFragment=new ServiceFragment();
        FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.ln_wrap,serviceFragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_service) {
            // Handle the camera action
            ServiceFragment serviceFragment=new ServiceFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ln_wrap,serviceFragment).commit();
        } else if (id == R.id.nav_history) {
            HistoryFragment historyFragment=new HistoryFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ln_wrap,historyFragment).commit();

        } else if (id == R.id.nav_accessary) {
            AccessaryFragment accessaryFragment=new AccessaryFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ln_wrap,accessaryFragment).commit();

        } else if (id == R.id.nav_about) {
            AboutFragment aboutFragment=new AboutFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ln_wrap,aboutFragment).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==114 && data!=null){
            String bienso=data.getStringExtra("bs");
            String nb=data.getStringExtra("nb");
            txtNumber.setText(nb);
            txtBienSo.setText(bienso);
        }else {
            Toast.makeText(this,"bạn phải chọn tài khoản thêm",Toast.LENGTH_LONG).show();
        }
    }
}

package com.example.daiphongpc.demomaintain.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.daiphongpc.demomaintain.Adapter.AccAdapter;
import com.example.daiphongpc.demomaintain.Model.Custommer;
import com.example.daiphongpc.demomaintain.R;

import java.util.ArrayList;

public class AccountOtherActivity extends AppCompatActivity {
    ArrayList<Custommer> arrData=new ArrayList<>();
    AccAdapter adapter;
    ListView lvAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_other);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvAcc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.putExtra("bs",arrData.get(position).getBienXe());
                intent.putExtra("nb",arrData.get(position).getNumberPhone());
                setResult(113,intent);
                finish();
            }
        });
    }

    private void addControls() {
        lvAcc=findViewById(R.id.lv_acc);
        arrData.add(new Custommer("0988434343","77-Ab"));
        arrData.add(new Custommer("09854545","39-ff"));
        adapter=new AccAdapter(this,arrData);
        lvAcc.setAdapter(adapter);
    }

    public void accOther(View view) {
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

package com.example.daiphongpc.demomaintain.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.daiphongpc.demomaintain.Model.Custommer;
import com.example.daiphongpc.demomaintain.R;

import java.util.ArrayList;
import java.util.List;

public class AccAdapter extends ArrayAdapter<Custommer> {
    Context context;
    ArrayList<Custommer> arrData;
    public AccAdapter(@NonNull Context context,  @NonNull ArrayList<Custommer> objects) {
        super(context, R.layout.item_acc, objects);
        this.context=context;
        this.arrData=objects;
    }

    @NonNull
    @Override
    public View getView(int position,@Nullable View convertView,@NonNull ViewGroup parent) {
        convertView=LayoutInflater.from(context).inflate(R.layout.item_acc,parent,false);
        TextView txtNumber,txtBienSo;
        txtBienSo=convertView.findViewById(R.id.txt_bienso);
        txtNumber=convertView.findViewById(R.id.txt_numberphon);
        txtBienSo.setText(arrData.get(position).getBienXe());
        txtNumber.setText(arrData.get(position).getNumberPhone());
        return convertView;

    }
}

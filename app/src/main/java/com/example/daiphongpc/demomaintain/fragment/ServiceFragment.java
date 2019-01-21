package com.example.daiphongpc.demomaintain.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daiphongpc.demomaintain.Adapter.ServiceApdater;
import com.example.daiphongpc.demomaintain.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceFragment extends Fragment {

    TabLayout tbService;
    ViewPager vpService;
    View view;

    public ServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Dịch vụ");
        view=inflater.inflate(R.layout.fragment_service, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tbService=view.findViewById(R.id.tb_service);
        vpService=view.findViewById(R.id.vp_service);
        vpService.setAdapter(new ServiceApdater(getFragmentManager()));
        tbService.setupWithViewPager(vpService);

    }
}

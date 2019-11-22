package com.yzs.viewpagerdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yzs.viewpagerdemo.activity.MainActivity;
import com.yzs.viewpagerdemo.R;

public class FragmentHome extends Fragment {
    LinearLayout tabHome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }


    private void initView(View view) {
        tabHome = view.findViewById(R.id.ll_home_tab);

        view.findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).clickHome();
            }
        });
        view.findViewById(R.id.btn_msg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).clickMsg();
            }
        });
        view.findViewById(R.id.btn_focus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).clickFocus();
            }
        });
    }


    public void setVisible() {
        tabHome.setVisibility(View.VISIBLE);
    }

    public void setGone() {
        tabHome.setVisibility(View.INVISIBLE);
    }

}

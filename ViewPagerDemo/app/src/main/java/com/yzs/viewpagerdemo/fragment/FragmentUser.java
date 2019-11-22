package com.yzs.viewpagerdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yzs.viewpagerdemo.CustomRecyclerView;
import com.yzs.viewpagerdemo.R;
import com.yzs.viewpagerdemo.adapter.UserListAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentUser extends Fragment {

    CustomRecyclerView rec;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rec = view.findViewById(R.id.rec);

        initData();
        UserListAdapter adapter = new UserListAdapter(list);

        rec.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false));
        rec.setAdapter(adapter);
    }

    List<String> list = new ArrayList<>();

    private void initData() {
        for (int i = 1; i <= 50; i++) {
            list.add("第 " + i + " 调数据");
        }

    }
}
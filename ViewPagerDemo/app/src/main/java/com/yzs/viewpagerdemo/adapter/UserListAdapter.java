package com.yzs.viewpagerdemo.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class UserListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public UserListAdapter(@Nullable List<String> data) {
        super(android.R.layout.simple_expandable_list_item_1, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        helper.setText(android.R.id.text1, item);
    }
}
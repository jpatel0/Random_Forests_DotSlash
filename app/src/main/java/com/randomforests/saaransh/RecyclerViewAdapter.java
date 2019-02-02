package com.randomforests.saaransh;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.ViewHolder {
    public TextView mTextView;
    public RecyclerViewAdapter(TextView v) {
        super(v);
        mTextView = v;
    }

}

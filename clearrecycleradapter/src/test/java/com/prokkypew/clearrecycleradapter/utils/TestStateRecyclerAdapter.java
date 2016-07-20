package com.prokkypew.clearrecycleradapter.utils;

import android.view.View;

import com.prokkypew.clearrecycleradapter.ClearRecyclerViewHolder;
import com.prokkypew.clearrecycleradapter.R;
import com.prokkypew.clearrecycleradapter.StateRecyclerAdapter;

/**
 * Created by Prokky on 20.07.2016.
 */
public class TestStateRecyclerAdapter extends StateRecyclerAdapter<TestObject> {

    @Override
    public int getErrorLayoutId() {
        return R.layout.empty_layout;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.empty_layout;
    }

    @Override
    public int getProgressLayoutId() {
        return R.layout.empty_layout;
    }

    @Override
    protected ClearRecyclerViewHolder getViewHolder(View view, int viewType) {
        return new TestViewHolder(view);
    }
}

package com.prokkypew.clearrecycleradapter.utils;

import android.view.View;

import com.prokkypew.clearrecycleradapter.ClearRecyclerAdapter;
import com.prokkypew.clearrecycleradapter.ClearRecyclerViewHolder;
import com.prokkypew.clearrecycleradapter.R;

import java.util.List;

/**
 * Created by alexander_roman on 19.07.16.
 */
public class TestRecyclerAdapter extends ClearRecyclerAdapter<TestObject> {

    public TestRecyclerAdapter() {
        super();
    }

    public TestRecyclerAdapter(List<TestObject> objects) {
        super(objects);
    }

    @Override
    protected ClearRecyclerViewHolder getViewHolder(View view, int viewType) {
        return new TestViewHolder(view);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.empty_layout;
    }
}

package com.prokkypew.clearrecycleradapter.utils;

import android.view.View;
import android.widget.TextView;

import com.prokkypew.clearrecycleradapter.ClearRecyclerViewHolder;
import com.prokkypew.clearrecycleradapter.R;

/**
 * Created by alexander_roman on 19.07.16.
 */
public class TestViewHolder extends ClearRecyclerViewHolder<TestObject> {
    TextView textView;

    public TestViewHolder(View v) {
        super(v);
        textView = (TextView) v.findViewById(R.id.title);
    }

    @Override
    public void bind(TestObject item) {
        textView.setText(item.text);
    }
}

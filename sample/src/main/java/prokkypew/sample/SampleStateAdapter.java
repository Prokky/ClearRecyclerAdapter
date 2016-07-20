package prokkypew.sample;

import android.view.View;

import com.prokkypew.clearrecycleradapter.ClearRecyclerViewHolder;
import com.prokkypew.clearrecycleradapter.StateRecyclerAdapter;

/**
 * Created by Prokky on 20.07.2016.
 */
public class SampleStateAdapter extends StateRecyclerAdapter<SampleObject> {

    @Override
    public int getErrorLayoutId() {
        return R.layout.sample_error_layout;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.sample_item_layout;
    }

    @Override
    public int getProgressLayoutId() {
        return R.layout.sample_progress_layout;
    }

    @Override
    protected ClearRecyclerViewHolder getViewHolder(View view, int viewType) {
        return new SampleViewHolder(view);
    }
}

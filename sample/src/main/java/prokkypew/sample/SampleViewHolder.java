package prokkypew.sample;

import android.view.View;
import android.widget.TextView;

import com.prokkypew.clearrecycleradapter.ClearRecyclerViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Prokky on 20.07.2016.
 */
public class SampleViewHolder extends ClearRecyclerViewHolder<SampleObject> {
    @BindView(R.id.text_view)
    TextView text;


    public SampleViewHolder(View v) {
        super(v);
        ButterKnife.bind(this, v);
    }

    @Override
    public void bind(SampleObject item) {
        text.setText(item.text);
    }
}

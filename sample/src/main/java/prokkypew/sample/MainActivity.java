package prokkypew.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prokkypew.clearrecycleradapter.StateRecyclerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    Unbinder unbinder;
    SampleStateAdapter adapter;

    @OnClick(R.id.state_error)
    void onErrorClick() {
        adapter.setState(StateRecyclerAdapter.AdapterState.ERROR);
    }

    @OnClick(R.id.state_loaded)
    void onLoadedClick() {
        adapter.setState(StateRecyclerAdapter.AdapterState.ITEMS);
    }

    @OnClick(R.id.state_progress)
    void onProgressClick() {
        adapter.setState(StateRecyclerAdapter.AdapterState.PROGRESS);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        adapter = new SampleStateAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        ArrayList<SampleObject> objects = new ArrayList<>();
        objects.add(new SampleObject("object one"));
        objects.add(new SampleObject("object two"));
        objects.add(new SampleObject("object three"));
        objects.add(new SampleObject("object eleven"));
        adapter.set(objects);
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}

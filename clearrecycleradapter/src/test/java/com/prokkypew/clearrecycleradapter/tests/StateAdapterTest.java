package com.prokkypew.clearrecycleradapter.tests;

import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.prokkypew.clearrecycleradapter.BuildConfig;
import com.prokkypew.clearrecycleradapter.StateRecyclerAdapter;
import com.prokkypew.clearrecycleradapter.utils.TestStateRecyclerAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by alexander_roman on 19.07.16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, manifest = "src/main/AndroidManifest.xml", sdk = 21)
public class StateAdapterTest {
    private TestStateRecyclerAdapter adapter;

    @Before
    public void beforeEachTest() {
        adapter = new TestStateRecyclerAdapter();
    }

    @Test
    public void test_setsState() {
        StateRecyclerAdapter.AdapterState state = StateRecyclerAdapter.AdapterState.ERROR;
        adapter.setState(state);
        assertEquals(state, adapter.getState());
    }

    @Test
    public void test_createViewHolder() {
        ViewGroup parent = new LinearLayout(RuntimeEnvironment.application.getApplicationContext());

        adapter.setState(StateRecyclerAdapter.AdapterState.ERROR);
        assertNotNull(adapter.onCreateViewHolder(parent, 0));

        adapter.setState(StateRecyclerAdapter.AdapterState.ITEMS);
        assertNotNull(adapter.onCreateViewHolder(parent, 0));

        adapter.setState(StateRecyclerAdapter.AdapterState.PROGRESS);
        assertNotNull(adapter.onCreateViewHolder(parent, 0));
    }

    @Test
    public void test_defaultViewType() {
        adapter.setState(StateRecyclerAdapter.AdapterState.ITEMS);
        assertEquals(adapter.getItemViewType(0), 0);
        adapter.setState(StateRecyclerAdapter.AdapterState.ERROR);
        assertEquals(adapter.getItemViewType(0), -998);
        adapter.setState(StateRecyclerAdapter.AdapterState.PROGRESS);
        assertEquals(adapter.getItemViewType(0), -999);
    }

    @Test
    public void test_getItemCount() {
        adapter.setState(StateRecyclerAdapter.AdapterState.ITEMS);
        assertEquals(adapter.getItemCount(), 0);
        adapter.setState(StateRecyclerAdapter.AdapterState.ERROR);
        assertEquals(adapter.getItemCount(), 1);
    }
}

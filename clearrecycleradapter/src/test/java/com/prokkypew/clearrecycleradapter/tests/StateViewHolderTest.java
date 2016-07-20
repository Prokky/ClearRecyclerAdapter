package com.prokkypew.clearrecycleradapter.tests;

import com.prokkypew.clearrecycleradapter.BuildConfig;
import com.prokkypew.clearrecycleradapter.StateRecyclerAdapter;
import com.prokkypew.clearrecycleradapter.StateRecyclerViewHolder;
import com.prokkypew.clearrecycleradapter.utils.TestObject;
import com.prokkypew.clearrecycleradapter.utils.TestStateRecyclerAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class StateViewHolderTest {
    private TestStateRecyclerAdapter adapter;

    @Before
    public void beforeEachTest() {
        adapter = new TestStateRecyclerAdapter();
    }

    @Test
    public void test_bindProgress() {
        List<TestObject> items = asList(
                new TestObject("one"),
                new TestObject("two"),
                new TestObject("three")
        );
        adapter.setState(StateRecyclerAdapter.AdapterState.PROGRESS);
        adapter.set(items);

        for (int position = 0, size = items.size(); position < size; position++) {
            StateRecyclerViewHolder itemViewHolder = mock(StateRecyclerViewHolder.class);
            adapter.onBindViewHolder(itemViewHolder, position);
            verify(itemViewHolder, never()).bind(items.get(position));
        }
    }

    @Test
    public void test_bindItems() {
        List<TestObject> items = asList(
                new TestObject("one"),
                new TestObject("two"),
                new TestObject("three")
        );
        adapter.setState(StateRecyclerAdapter.AdapterState.ITEMS);
        adapter.set(items);

        for (int position = 0, size = items.size(); position < size; position++) {
            StateRecyclerViewHolder itemViewHolder = mock(StateRecyclerViewHolder.class);
            adapter.onBindViewHolder(itemViewHolder, position);
            verify(itemViewHolder).bind(items.get(position));
        }
    }
}
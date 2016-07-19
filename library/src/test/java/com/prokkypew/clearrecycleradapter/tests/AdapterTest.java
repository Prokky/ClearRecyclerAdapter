package com.prokkypew.clearrecycleradapter.tests;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.prokkypew.clearrecycleradapter.BuildConfig;
import com.prokkypew.clearrecycleradapter.utils.TestObject;
import com.prokkypew.clearrecycleradapter.utils.TestRecyclerAdapter;
import com.prokkypew.clearrecycleradapter.utils.TestViewHolder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by alexander_roman on 19.07.16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, manifest = "src/main/AndroidManifest.xml", sdk = 21)
public class AdapterTest {
    private TestRecyclerAdapter adapter;

    @Before
    public void beforeEachTest() {
        adapter = new TestRecyclerAdapter();
    }

    @Test
    public void test_shouldThrowOnNullCtorParameters() {
        Exception ex = null;
        try {
            adapter = new TestRecyclerAdapter(null);
        } catch (Exception e) {
            ex = e;
        }
        assertNotNull(ex);
    }

    @Test
    public void test_adapterSizeCtor() {
        adapter = new TestRecyclerAdapter(asList(mock(TestObject.class), mock(TestObject.class)));
        assertSame(adapter.getItemCount(), 2);
        assertSame(adapter.getItems().size(), 2);
    }


    @Test
    public void test_adapterEmptyDefault() {
        assertSame(adapter.getItemCount(), 0);
        assertSame(adapter.getItems().size(), 0);
    }

    @Test
    public void test_adapterSize() {
        adapter.set(asList(mock(TestObject.class), mock(TestObject.class)));
        assertSame(adapter.getItemCount(), 2);
        assertSame(adapter.getItems().size(), 2);
    }

    @Test
    public void test_adapterNotify() {
        RecyclerView.AdapterDataObserver observer = mock(RecyclerView.AdapterDataObserver.class);
        adapter.registerAdapterDataObserver(observer);

        adapter.set(new ArrayList<TestObject>());
        verify(observer).onChanged();
        verifyNoMoreInteractions(observer);
    }

    @Test
    public void test_createViewHolder() {
        ViewGroup parent = new LinearLayout(RuntimeEnvironment.application.getApplicationContext());

        TestViewHolder viewHolder = (TestViewHolder) adapter.onCreateViewHolder(parent, 0);
        assertNotNull(viewHolder);
    }

    @Test
    public void test_bindViewHolder() {
        List<TestObject> items = asList(
                new TestObject("one"),
                new TestObject("two"),
                new TestObject("three")
        );

        adapter.set(items);

        for (int position = 0, size = items.size(); position < size; position++) {
            TestViewHolder itemViewHolder = mock(TestViewHolder.class);
            adapter.onBindViewHolder(itemViewHolder, position);
            verify(itemViewHolder).bind(items.get(position));
        }
    }

    @Test
    public void test_adapterAddAll() {
        adapter.set(new ArrayList<>(Arrays.asList(mock(TestObject.class), mock(TestObject.class))));

        RecyclerView.AdapterDataObserver observer = mock(RecyclerView.AdapterDataObserver.class);
        adapter.registerAdapterDataObserver(observer);

        List<TestObject> items = new ArrayList<>(Arrays.asList(mock(TestObject.class), mock(TestObject.class)));
        adapter.addAll(items);

        verify(observer).onChanged();
        verifyNoMoreInteractions(observer);

        assertSame(adapter.getItemCount(), 4);
        assertSame(adapter.getItems().size(), 4);
    }

    @Test
    public void test_adapterAdd() {
        adapter.set(new ArrayList<>(Arrays.asList(mock(TestObject.class), mock(TestObject.class))));

        RecyclerView.AdapterDataObserver observer = mock(RecyclerView.AdapterDataObserver.class);
        adapter.registerAdapterDataObserver(observer);

        adapter.add(mock(TestObject.class));

        verify(observer).onItemRangeInserted(2, 1);
        verifyNoMoreInteractions(observer);

        assertSame(adapter.getItemCount(), 3);
        assertSame(adapter.getItems().size(), 3);
    }

    @Test
    public void test_adapterInsert() {
        adapter.set(new ArrayList<>(Arrays.asList(mock(TestObject.class), mock(TestObject.class))));

        RecyclerView.AdapterDataObserver observer = mock(RecyclerView.AdapterDataObserver.class);
        adapter.registerAdapterDataObserver(observer);

        adapter.add(mock(TestObject.class), 1);

        verify(observer).onItemRangeInserted(1, 1);
        verifyNoMoreInteractions(observer);

        assertSame(adapter.getItemCount(), 3);
        assertSame(adapter.getItems().size(), 3);
    }

    @Test
    public void test_adapterClear() {
        adapter.set(new ArrayList<>(Arrays.asList(mock(TestObject.class), mock(TestObject.class))));

        RecyclerView.AdapterDataObserver observer = mock(RecyclerView.AdapterDataObserver.class);
        adapter.registerAdapterDataObserver(observer);

        adapter.clear();

        verify(observer).onChanged();
        verifyNoMoreInteractions(observer);

        assertSame(adapter.getItemCount(), 0);
        assertSame(adapter.getItems().size(), 0);
    }


    @Test
    public void test_adapterRemove() {
        TestObject obj = new TestObject("123");
        adapter.set(new ArrayList<>(Arrays.asList(mock(TestObject.class), obj)));

        RecyclerView.AdapterDataObserver observer = mock(RecyclerView.AdapterDataObserver.class);
        adapter.registerAdapterDataObserver(observer);

        adapter.remove(obj);

        verify(observer).onItemRangeRemoved(1, 1);
        verifyNoMoreInteractions(observer);

        assertSame(adapter.getItemCount(), 1);
        assertSame(adapter.getItems().size(), 1);
    }


    @Test
    public void test_adapterUpdate() {
        TestObject obj = new TestObject("123");
        adapter.set(new ArrayList<>(Arrays.asList(mock(TestObject.class), obj)));

        RecyclerView.AdapterDataObserver observer = mock(RecyclerView.AdapterDataObserver.class);
        adapter.registerAdapterDataObserver(observer);

        obj.text = "new";
        adapter.update(obj);

        verify(observer).onItemRangeChanged(1, 1, null);
        verifyNoMoreInteractions(observer);

        assertEquals(obj.text, adapter.getItems().get(1).text);
    }
}

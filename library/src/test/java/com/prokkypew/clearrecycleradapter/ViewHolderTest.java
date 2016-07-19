package com.prokkypew.clearrecycleradapter;

import android.view.View;
import android.widget.TextView;

import com.prokkypew.clearrecycleradapter.utils.TestObject;
import com.prokkypew.clearrecycleradapter.utils.TestViewHolder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class ViewHolderTest {
    private TextView textView;
    private View itemView;
    private TestObject testObject;
    private TestViewHolder testViewHolder;

    @Before
    public void beforeEachTest() {
        textView = mock(TextView.class);
        itemView = mock(View.class);
        when(itemView.findViewById(R.id.title)).thenReturn(textView);

        testObject = new TestObject("title");
        testViewHolder = new TestViewHolder(itemView);
    }

    @Test
    public void bind_shouldSetTitle() {
        testViewHolder.bind(testObject);
        verify(textView).setText(testObject.text);
    }
}
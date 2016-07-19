package com.prokkypew.clearrecycleradapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by alexander_roman on 19.07.16.
 */
@SuppressWarnings("unchecked")
public abstract class ClearRecyclerViewHolder<T extends Object> extends RecyclerView.ViewHolder {

    public ClearRecyclerViewHolder(final View itemView) {
        super(itemView);
    }

    public abstract void bind(T item);
}

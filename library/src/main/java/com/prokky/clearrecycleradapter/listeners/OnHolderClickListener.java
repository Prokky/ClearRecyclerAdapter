package com.prokky.clearrecycleradapter.listeners;

/**
 * Created by Prokky on 18.07.2016.
 */
public interface OnHolderClickListener<T extends Object> {
    void onClick(T item, int position);
}

package com.prokky.clearrecycleradapter.listeners;

/**
 * Created by Prokky on 18.07.2016.
 */
public interface OnHolderLongClickListener<T extends Object> {
    boolean onLongClick(T item, int position);
}

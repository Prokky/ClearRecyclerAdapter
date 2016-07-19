package com.prokkypew.clearrecycleradapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prokky on 18.07.2016.
 */
public abstract class ClearRecyclerAdapter<T extends Object> extends RecyclerView.Adapter<ClearRecyclerViewHolder> {
    protected List<T> items = new ArrayList<>();

    public ClearRecyclerAdapter() {

    }

    public ClearRecyclerAdapter(List<T> items) {
        if (items == null)
            throw new IllegalArgumentException("items cannot be null");
        this.items = items;
    }

    @Override
    public ClearRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(getItemLayout(viewType), parent, false);
        return getViewHolder(view, viewType);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(ClearRecyclerViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void set(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void addAll(List<T> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void add(T item) {
        items.add(item);
        notifyItemInserted(items.indexOf(item));
    }

    public void add(T item, int position) {
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void update(T item) {
        int pos = items.indexOf(item);
        if (pos != -1) {
            items.remove(pos);
            items.add(pos, item);
            notifyItemChanged(pos);
        }
    }

    public void remove(T item) {
        int pos = items.indexOf(item);
        if (pos != -1) {
            notifyItemRemoved(pos);
            items.remove(item);
        }
    }

    public List<T> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    protected abstract ClearRecyclerViewHolder getViewHolder(View view, int viewType);

    protected abstract int getItemLayout(int viewType);


}

package com.prokky.clearrecycleradapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prokky.clearrecycleradapter.listeners.OnHolderClickListener;
import com.prokky.clearrecycleradapter.listeners.OnHolderLongClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Prokky on 18.07.2016.
 */
public abstract class ClearRecyclerAdapter<T extends Object> extends RecyclerView.Adapter<ClearRecyclerAdapter.ClearRecyclerViewHolder> {
    protected List<T> items = new ArrayList<>();
    private OnHolderClickListener onClickListener;
    private OnHolderLongClickListener onLongClickListener;

    public void setOnHolderClickListener(
            OnHolderClickListener<T> onItemClickListener) {
        this.onClickListener = onItemClickListener;
    }

    public void setOnHolderLongClickListener(
            OnHolderClickListener<T> onItemClickListener) {
        this.onClickListener = onItemClickListener;
    }

    @Override
    public ClearRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(getItemLayout(), parent, false);
        return getViewHolder(view);
    }

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

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    protected abstract ClearRecyclerViewHolder getViewHolder(View view);

    protected abstract int getItemLayout();

    @SuppressWarnings("unchecked")
    public abstract class ClearRecyclerViewHolder extends RecyclerView.ViewHolder {

        public ClearRecyclerViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            if (onClickListener != null)
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClick(items.get(getAdapterPosition()), getAdapterPosition());
                    }
                });
            if (onLongClickListener != null)
                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        return onLongClickListener.onLongClick(items.get(getAdapterPosition()), getAdapterPosition());
                    }
                });
        }

        public abstract void bind(T item);
    }
}

package com.prokkypew.clearrecycleradapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Prokky on 20.07.2016.
 */
public abstract class StateRecyclerAdapter<T extends Object> extends ClearRecyclerAdapter<T> {
    private AdapterState currentState = AdapterState.PROGRESS;

    public AdapterState getState() {
        return currentState;
    }

    public void setState(AdapterState currentState) {
        this.currentState = currentState;
        notifyDataSetChanged();
    }

    @Override
    public ClearRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(getStateLayoutId(viewType), parent, false);
        return getStateViewHolder(view, viewType);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(ClearRecyclerViewHolder holder, int position) {
        if (currentState == AdapterState.ITEMS)
            holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        if (currentState == AdapterState.ITEMS)
            return super.getItemCount();
        else
            return 1;
    }

    @Override
    public int getItemViewType(int position) {
        switch (currentState) {
            case ITEMS:
                return 0;
            case PROGRESS:
                return 1;
            case ERROR:
            default:
                return 2;
        }
    }

    public abstract int getErrorLayoutId();

    public abstract int getProgressLayoutId();

    private int getStateLayoutId(int type) {
        switch (currentState) {
            case ITEMS:
                return getItemLayoutId(type);
            case PROGRESS:
                return getProgressLayoutId();
            case ERROR:
            default:
                return getErrorLayoutId();
        }
    }

    private ClearRecyclerViewHolder getStateViewHolder(View v, int viewType) {
        switch (currentState) {
            case ITEMS:
                return getViewHolder(v, viewType);
            case PROGRESS:
            case ERROR:
            default:
                return new StateRecyclerViewHolder(v);
        }
    }

    public enum AdapterState {PROGRESS, ERROR, ITEMS}
}

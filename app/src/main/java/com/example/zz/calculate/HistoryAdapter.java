package com.example.zz.calculate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zz on 17-5-13.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private List<History> mHistoryList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView functionView;
        TextView resultView;

        public ViewHolder(View view) {
            super(view);
            functionView = (TextView) view.findViewById(R.id.function_view);
            resultView = (TextView) view.findViewById(R.id.result_view);
        }
    }

    public HistoryAdapter(List<History> historyList) {
        mHistoryList = historyList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        History history = mHistoryList.get(position);
        holder.functionView.setText("算式：\n"+history.getFunction());
        holder.resultView.setText("结果：\n"+history.getResult());
    }

    @Override
    public int getItemCount() {
        return mHistoryList.size();
    }
}

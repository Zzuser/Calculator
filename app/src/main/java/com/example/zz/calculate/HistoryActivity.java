package com.example.zz.calculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/***
 * Created by zz on 17-5-13.
 * 计算器历史记录显示界面
 *  historyList用来容纳所有的历史记录条目，数据由MainActivity传入
 */

public class HistoryActivity extends AppCompatActivity {
    private List<History> historyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        historyList = (List<History>)getIntent().getSerializableExtra("historyData");
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view_history);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        HistoryAdapter adapter=new HistoryAdapter(historyList);
        recyclerView.setAdapter(adapter);
    }
}

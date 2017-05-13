package com.example.zz.calculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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

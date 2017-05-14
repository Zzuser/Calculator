package com.example.zz.calculate;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/***
 * Created by zz on 17-5-12.
 * 计算器的主界面，包含显示文本框和键盘
 * 文本框注册在MainActivity里，分上下两层，上层用于显示计算公式，下层用于显示输入的数据和计算结果
 * 键盘被装入一个RecyclerView中，frameList来容纳所有键盘类型，可以通过滑动获取超出屏幕外的键盘
 *
 * 两个List集合：
 * frameList是装入不同类键盘的容器，用initFrames（）方法来初始化，暂时装入了base和science两类键盘
 * historyList是装入历史记录的容器，用addHistoryList()从FrameAdapter类中获取计算的历史记录
 *
 * ReFlashTextView()方法用了定位文本框中的数据，当数据长度超出文本框大小时使其向上滚动
 * toHistory（）方法用来跳转到HistoryActivity以便查询历史记录
 *
 */
public class MainActivity extends AppCompatActivity {
    private List<Frame> frameList = new ArrayList<>();
    private List<History> historyList = new ArrayList<>();
    TextView textView;
    TextView textViewTop;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        textView = (TextView) findViewById(R.id.bottom_text);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textViewTop = (TextView) findViewById(R.id.top_text);
        textViewTop.setMovementMethod(ScrollingMovementMethod.getInstance());
        initFrames();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FrameAdapter adapter = new FrameAdapter(this, frameList);
        recyclerView.setAdapter(adapter);
    }

    private void initFrames() {
        Frame base = new Frame(0);
        frameList.add(base);
        Frame science = new Frame(1);
        frameList.add(science);
    }

    public void ReFlashTextView() {
        int offset = textView.getLineCount() * textView.getLineHeight();
        if (offset > textView.getHeight()) {
            textView.scrollTo(0, offset - textView.getHeight());
        }
        int offset1 = textViewTop.getLineCount() * textViewTop.getLineHeight();
        if (offset1 > textViewTop.getHeight()) {
            textViewTop.scrollTo(0, offset1 - textViewTop.getHeight());
        }
    }
    public void addHistoryList(String function,String result){
        historyList.add(new History(function,result));
    }
    public void toHistory(){
        Intent intent = new Intent(MainActivity.this,HistoryActivity.class);
        intent.putExtra("historyData",(Serializable)historyList);
        startActivity(intent);
    }
}

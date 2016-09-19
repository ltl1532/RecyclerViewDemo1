package com.bc.ltl.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> datas = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myAdapter = new MyAdapter(datas);
        mRecyclerView.setAdapter(myAdapter);
        //listview 样式
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        //设置为默认动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position, String city) {
                Toast.makeText(MainActivity.this, "city:" + city + ",position:" + position, Toast.LENGTH_SHORT).show();
            }
        });


        //gridview 样式
        // mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //瀑布流样式
        // mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));


    }

    private void initDatas() {
        datas.add("纽约尼克斯");
        datas.add("华盛顿奇才");
        datas.add("夏洛特黄蜂");
        datas.add("洛杉矶湖人");
        datas.add("休斯顿火箭");
        datas.add("迈阿密热火");
        datas.add("孟菲斯灰熊");
        datas.add("达拉斯小牛");
        datas.add("内蒙古小邬");
        datas.add("山西张六斤");
        datas.add("菲尼克斯太阳");
        datas.add("克利夫兰骑士");
        datas.add("圣安东尼奥马刺");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_action_add:
                myAdapter.addData(0, "new city");
                break;
            case R.id.id_action_delete:
                myAdapter.removeData(1);
                break;
            case R.id.id_action_gridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                break;
            case R.id.id_action_listview:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.id_action_staview:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                break;
        }
            return true;
    }
}

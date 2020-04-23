package com.example.manage.activity;

import android.app.Dialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.manage.R;
import com.example.manage.adapter.SearchHistoryAdapter;
import com.example.manage.adapter.SearchHotAdapter;
import com.example.manage.utils.SearchDbHelper;
import com.example.manage.view.SureDialog;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView image_back;
    private RecyclerView recycle_search, recycle_history;
    private EditText et_search;
    private TextView tv_search;
    private FlexboxLayoutManager flexboxHot;
    private FlexboxLayoutManager flexboxHistory;
    private SearchHotAdapter searchHotAdapter;
    private SearchHistoryAdapter historyAdapter;
    private SureDialog sureDialog;

    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initView();
        initData();
        dbHelper();
    }

    private void initView() {
        recycle_search = findViewById(R.id.recycle_search);
        image_back = findViewById(R.id.image_back);
        et_search = findViewById(R.id.et_search);
        tv_search = findViewById(R.id.tv_search);
        recycle_history = findViewById(R.id.recycle_history);


        image_back.setOnClickListener(this);
        tv_search.setOnClickListener(this);

    }

    private void initData() {
        sureDialog = new SureDialog(this, R.style.dialog);
        mList.add("英协广场");
        mList.add("苏协大厦斜路");
        mList.add("中国银行");
        mList.add("中上");
        mList.add("新政路");
        mList.add("中央商务区");
        mList.add("英协广场");

        flexboxHot = new FlexboxLayoutManager(this);
        //设置主轴排列方式
        flexboxHot.setFlexDirection(FlexDirection.ROW);
        //设置是否换行
        flexboxHot.setFlexWrap(FlexWrap.WRAP);
        flexboxHot.setAlignItems(AlignItems.STRETCH);

        flexboxHistory = new FlexboxLayoutManager(this);
        //设置主轴排列方式
        flexboxHistory.setFlexDirection(FlexDirection.ROW);
        //设置是否换行
        flexboxHistory.setFlexWrap(FlexWrap.WRAP);
        flexboxHistory.setAlignItems(AlignItems.STRETCH);

        recycle_search.setLayoutManager(flexboxHot);
        searchHotAdapter = new SearchHotAdapter(R.layout.item_search_hot, mList);
        recycle_search.setAdapter(searchHotAdapter);
        searchHotAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ll_item:
                        Toast.makeText(SearchActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        recycle_history.setLayoutManager(flexboxHistory);
        historyAdapter = new SearchHistoryAdapter(R.layout.item_search_hot, mHistoryList);
        recycle_history.setAdapter(historyAdapter);
        historyAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ll_item:
                        Toast.makeText(SearchActivity.this, mHistoryList.get(position), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        historyAdapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, final int position) {
                switch (view.getId()) {
                    case R.id.ll_item:

                        sureDialog.show();

                        sureDialog.findViewById(R.id.dialog_general_style1_bt1).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sureDialog.dismiss();
                            }
                        });
                        sureDialog.findViewById(R.id.dialog_general_style1_bt2).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //删除对应数据库内容
                                db.delete("user", "name=?", new String[]{mHistoryList.get(position)});
                                Query();
                                sureDialog.dismiss();
                            }
                        });

                        break;
                }
                return false;
            }
        });

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    image_back.setVisibility(View.VISIBLE);
                } else {
                    image_back.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                et_search.setText("");
                image_back.setVisibility(View.GONE);
                break;
            case R.id.tv_search:
                if (!et_search.getText().toString().equals("")) {
                    //创建存放数据的ContentValues对象
                    ContentValues values = new ContentValues();
                    values.put("name", et_search.getText().toString());
                    //数据库执行插入命令
                    db.insert("user", null, values);
                    Query();
                } else {
                    Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    private List<String> mHistoryList = new ArrayList<>();
    private SQLiteDatabase db;

    private void dbHelper() {
        //依靠DatabaseHelper带全部参数的构造函数创建数据库
        SearchDbHelper dbHelper = new SearchDbHelper(SearchActivity.this, "name", null, 1);
        db = dbHelper.getWritableDatabase();
        Query();
    }

    private void Query() {
        //创建游标对象
        Cursor cursor = db.query("user", new String[]{"name"}, null, null, null, null, null);
        //利用游标遍历所有数据对象
        //为了显示全部，把所有对象取出
        mHistoryList.clear();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            mHistoryList.add(name);
            Collections.reverse(mHistoryList);
        }
        historyAdapter.notifyDataSetChanged();
        // 关闭游标，释放资源
        cursor.close();
    }
}

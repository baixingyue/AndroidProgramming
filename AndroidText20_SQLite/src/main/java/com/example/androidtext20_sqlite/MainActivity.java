package com.example.androidtext20_sqlite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText key, word, interpret;// 查询关键字输入框、添加页面中单词的输入框以及解释的输入框
    private MyDatabaseHelper mHelper;// 数据库辅助类
    private SQLiteDatabase mDatabase;// 数据库
    private ListView result;// 查询结果列表
    private TextView resultHint;// 不存在结果时的提示信息
    private int flag = 1;// flag=0时，显示查询页面，flag=1时，显示添加页面
    private Button add;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadActivity(0);
        // 补充完整 提示：数据库的初始化
        mHelper = new MyDatabaseHelper(MainActivity.this, "dict_tb.db", 1);
        mDatabase = mHelper.getReadableDatabase();
        System.out.print("hahhahah");
    }

    public void loadActivity(int flag) {
        if (flag == 0) {
            // 补充完整 提示：显示查询页面
            MainActivity.this.setContentView(R.layout.activity_main);
            result = (ListView) findViewById(R.id.result);
            key = (EditText) findViewById(R.id.key);
            Button search = (Button) findViewById(R.id.search);
            search.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    search(v);
                }
            });
        } else if (flag == 1) {
            // 补充完整 提示：显示添加页面
            MainActivity.this.setContentView(R.layout.add_main);
            word = (EditText) findViewById(R.id.word);
            interpret = (EditText) findViewById(R.id.interpret);
            add = (Button) findViewById(R.id.add);
            add.setOnClickListener(new OnClickListener() {

                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    add(v);
                }
            });
            Button reset = (Button) findViewById(R.id.reset);
            reset.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    reset(v);
                }
            });
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void search(View view) {// 查询页面中，查询按钮的事件处理
        Cursor cursor = mDatabase.rawQuery("select * from dict_tb where word like ? or interpret like ?", new String[]{"%" + key.getText().toString() + "%", "%" + key.getText().toString() + "%"});
        List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
        while (cursor.moveToNext()) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("word", cursor.getString(1));
            item.put("interpret", cursor.getString(2));
            resultList.add(item);
        }
        if (resultList == null || resultList.size() == 0) {
            // 补充完整 提示：不存在记录时，显示提示信息
            Toast.makeText(this, "很遗憾，没有相关记录！", Toast.LENGTH_LONG).show();
            flag = 1;
            // 补充完整 提示：显示添加页面
            loadActivity(flag);


        } else {
            // 补充完整 提示：将记录显示到列表中
            SimpleAdapter simpleAdapter = new SimpleAdapter(this, resultList, R.layout.item, new String[]{"word", "interpret"}, new int[]{R.id.word, R.id.interpret});

            result.setAdapter(simpleAdapter);
        }
    }

    public void add(View view) {// 添加页面中，添加按钮的事件处理
        // 补充完整 提示：向数据库中插入一条记录
        String word_1 = word.getText().toString();
        String interpret_1 = interpret.getText().toString();
        mDatabase.execSQL("insert into dict_tb values(null,?,?)", new String[]{word_1, interpret_1});
        Toast.makeText(this, "添加生词成功！", Toast.LENGTH_LONG).show();
        this.word.setText("");
        this.interpret.setText("");
        flag = 0;
        loadActivity(flag);
    }

    public void reset(View view) {// 添加页面中，重置按钮的事件处理
        word.setText("");
        interpret.setText("");
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // 补充完整 提示：选项菜单选中事件处理
        switch (item.getItemId()) {
            case R.id.searchItem:// 查询菜单
                loadActivity(0);
                //onCreate(null);
                break;
            case R.id.exit:// 单击退出按钮
                //this.finish();
                loadActivity(0);
                // onCreate(null);
                break;
            case R.id.addItem:// 增加按钮
                loadActivity(1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

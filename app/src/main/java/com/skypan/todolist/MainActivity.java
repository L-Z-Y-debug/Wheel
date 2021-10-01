package com.skypan.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

import com.skypan.todolist.*;
public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private TODO_Adapter.OnItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = findViewById(R.id.myRecyclerView);

        View SetInfoView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_set_info,null);
        EditText et_content_set = SetInfoView.findViewById(R.id.et_content);
        EditText et_time_set = SetInfoView.findViewById(R.id.et_time);

        View GetInfoView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_todolist_item,null);
        TextView todo_content = GetInfoView.findViewById(R.id.todo_content);
        TextView todo_time = GetInfoView.findViewById(R.id.todo_time);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(manager);

        myRecyclerView.setAdapter(new TODO_Adapter(MainActivity.this, new TODO_Adapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
//                Toast.makeText(MainActivity.this,"pos"+pos,Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("设置待办事项")
                        .setView(SetInfoView)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //获取输入框的内容并保存
                                todo_content.setText(et_content_set.getText().toString());
                                todo_time.setText(et_time_set.getText().toString());
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create()
                        .show();
            }
        }));
    }
}
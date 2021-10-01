package com.skypan.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TODO_Adapter extends RecyclerView.Adapter<TODO_Adapter.Holder>{

    private List<TODO_Info> info_list=null;
    private Context context;
    private OnItemClickListener listener;

    public TODO_Adapter(Context context, OnItemClickListener listener)  //构造器1
    {
        this.context=context;
        this.listener = listener;
    }

    public TODO_Adapter(Context context, OnItemClickListener listener, List<TODO_Info> list)  //构造器2
    {
        this.context = context;
        this.listener = listener;
        this.info_list = list;
    }

    class Holder extends RecyclerView.ViewHolder  //数据内部类
    {
        private CheckBox todo_finish;
        private TextView todo_content,todo_time;
        private Button todo_delete;

        public Holder(@NonNull View itemView) {
            super(itemView);
            todo_finish = itemView.findViewById(R.id.CB_finish);
            todo_content = itemView.findViewById(R.id.todo_content);
            todo_time = itemView.findViewById(R.id.todo_time);
            todo_delete = itemView.findViewById(R.id.todo_delete);
        }
    }

    @NonNull
    @Override
    public TODO_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.layout_todolist_item,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TODO_Adapter.Holder holder, int position) {
        holder.todo_content.setText("这是to-do-list的内容");
        holder.todo_time.setText(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public interface OnItemClickListener
    {
        void onClick(int pos);
    }
}
//

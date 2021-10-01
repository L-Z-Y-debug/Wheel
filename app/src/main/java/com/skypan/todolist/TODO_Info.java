package com.skypan.todolist;

public class TODO_Info {
    private String content,time;
    public TODO_Info(String content,String time)
    {
        this.content = content;
        this.time = time;
    }

    public TODO_Info(){};
    public void setContent(String content)
    {
        this.content = content;
    }
    public void setTime(String time)
    {
        this.time = time;
    }
    public String getContent()
    {
        return this.content;
    }
    public String getTime()
    {
        return this.time;
    }
}

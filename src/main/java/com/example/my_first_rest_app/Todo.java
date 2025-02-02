package com.example.my_first_rest_app;

public class Todo {

    private Integer id;
    private String description;
    private boolean isDone;


    
    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public void setIsDone(boolean isDone){
        this.isDone = isDone;
    }

    public boolean getIsDone(){
        return this.isDone;
    }
}

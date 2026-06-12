package com.librarymanagementsystem.model;

public class Member {

    private int id;
    private String name;

    public Member(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "ID : " + id +" | Name: "+ name;
    }
}

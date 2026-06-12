package com.librarymanagementsystem.repository;

import com.librarymanagementsystem.model.BorrowRecord;

import java.util.ArrayList;
import java.util.List;

public class BorrowRepository {

    private final  List<BorrowRecord> records = new ArrayList<>();

    public void save(BorrowRecord record){
        records.add(record);
    }

    public List<BorrowRecord> findAll(){
        return records;
    }

}

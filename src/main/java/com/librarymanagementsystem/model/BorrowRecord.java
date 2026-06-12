package com.librarymanagementsystem.model;

public class BorrowRecord {

    private int bookId;
    private int memberId;

    public BorrowRecord(int bookId , int memberId){
        this.bookId =  bookId;
        this.memberId = memberId;
    }

    public int getBookId(){
        return  bookId;
    }

    public int getMemberId() {
        return memberId;
    }
}

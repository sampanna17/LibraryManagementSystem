package com.librarymanagementsystem.service;

import com.librarymanagementsystem.model.Member;
import com.librarymanagementsystem.repository.MemeberRepository;

import java.awt.desktop.SystemEventListener;

public class BorrowService {

    private final MemeberRepository repository = new MemeberRepository();

    public void addMember(Member member){
        repository.save(member);
    }

    public void displayMembers(){
        for (Member member: repository.findAll()){
            System.out.println(member);
        }
    }

    public Member findMember(int id){
        return repository.findById(id);
    }

}

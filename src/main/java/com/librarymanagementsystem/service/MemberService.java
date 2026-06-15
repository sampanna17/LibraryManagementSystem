package com.librarymanagementsystem.service;

import com.librarymanagementsystem.model.Member;
import com.librarymanagementsystem.repository.MemberRepository;

public class MemberService {

    private final MemberRepository repository = new MemberRepository();

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

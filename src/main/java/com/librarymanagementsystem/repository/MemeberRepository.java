package com.librarymanagementsystem.repository;

import com.librarymanagementsystem.model.Member;
import java.util.ArrayList;
import java.util.List;

public class MemeberRepository {

    private final List<Member> members = new ArrayList<>();

    public void save(Member member){
        members.add(member);
    }

    public List<Member> findAll() {
        return members;
    }

    public Member findById(int id){
        for (Member member : members){
            if(member.getId() == id){
                return member;
            }
        }
        return null;
    }
}

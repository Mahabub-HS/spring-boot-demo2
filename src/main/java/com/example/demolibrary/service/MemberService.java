package com.example.demolibrary.service;

import com.example.demolibrary.exception.ResourceNotFoundException;
import com.example.demolibrary.model.Book;
import com.example.demolibrary.model.Member;
import com.example.demolibrary.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAll(){
        List<Member> memberList = new ArrayList<>();
        memberRepository.findAll().forEach(memberList::add);
        return memberList;
    }

    public Member findByUsername(String username) throws ResourceNotFoundException {
        Member member = memberRepository.findById(username).orElseThrow(ResourceNotFoundException::new);
        return member;
    }
}

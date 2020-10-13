package com.example.demolibrary.controller;

import com.example.demolibrary.exception.ResourceNotFoundException;
import com.example.demolibrary.model.Book;
import com.example.demolibrary.model.Member;
import com.example.demolibrary.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member")
    public ResponseEntity<List<Member>> getMember(){
        List<Member> memberList = memberService.findAll();
        return ResponseEntity.ok(memberList);

    }

    @GetMapping("/{username}")
    public ResponseEntity<Member>findByusername(@PathVariable String username){
        try {
            Member member = memberService.findByUsername(username);
            return ResponseEntity.ok(member);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }
}

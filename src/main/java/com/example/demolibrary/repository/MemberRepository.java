package com.example.demolibrary.repository;

import com.example.demolibrary.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member,String> {
    Iterable<Member> findByName(String username);
}

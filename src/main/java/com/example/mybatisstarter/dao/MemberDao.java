package com.example.mybatisstarter.dao;

import com.example.mybatisstarter.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberDao {
    Long save(Member member);

    List<Member> findAll();

    Optional<Member> findById(Long id);

    void remove(Long id);

    void update(Member member);
}

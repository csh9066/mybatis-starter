package com.example.mybatisstarter.dao;

import com.example.mybatisstarter.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberDao {
    Integer save(@Param("member") Member member);

    List<Member> findAll();
}

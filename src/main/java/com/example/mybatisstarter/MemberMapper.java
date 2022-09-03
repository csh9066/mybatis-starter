package com.example.mybatisstarter;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Insert("insert into member(nickname) values(#{member.nickname})")
    Integer save(@Param("member") Member member);

    @Select("select * from member")
    List<Member> findAll();

    @Select("select * from member where id = #{id}")
    Member findById(@Param("id") Long id);
}

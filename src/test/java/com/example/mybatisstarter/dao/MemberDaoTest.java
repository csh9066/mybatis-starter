package com.example.mybatisstarter.dao;

import com.example.mybatisstarter.model.Member;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
class MemberDaoTest {

    @Autowired
    MemberDao memberDao;

    @Test
    void findAll() {
        // given
        Member member = new Member();
        member.setNickname("babo");
        member.setAge(30);
        memberDao.save(member);

        // when
        List<Member> members = memberDao.findAll();

        members.forEach(System.out::println);

        // then
        assertThat(members).hasSize(1);
        assertThat(members).element(0)
                .extracting("age").isEqualTo(30);
    }

}

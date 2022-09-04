package com.example.mybatisstarter.dao;

import com.example.mybatisstarter.model.Member;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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

        // then
        assertThat(members).hasSize(1);
        assertThat(members).element(0)
                .extracting("age").isEqualTo(30);
    }

    @Test
    void findById() {
        // given
        Member member = new Member();
        member.setNickname("babo");
        member.setAge(30);
        Long savedId = memberDao.save(member);

        // when
        Optional<Member> resultOptional = memberDao.findById(savedId);

        // then
        assertThat(resultOptional.isPresent()).isTrue();

        Member result = resultOptional.get();
        assertThat(result.getAge()).isEqualTo(30);
        assertThat(result.getNickname()).isEqualTo("babo");
    }

    @Test
    void remove() {
        // given
        Member member = new Member();
        member.setNickname("babo");
        member.setAge(30);
        Long savedId = memberDao.save(member);

        // when
        memberDao.remove(savedId);

        // then
        Optional<Member> resultOptional = memberDao.findById(savedId);

        assertThat(resultOptional.isEmpty()).isTrue();
    }

    @Test
    void update() {
        // given
        Member member = new Member();
        member.setNickname("babo");
        member.setAge(30);
        Long savedId = memberDao.save(member);

        Member memberToUpdate = new Member();
        memberToUpdate.setAge(31);
        memberToUpdate.setNickname("kimchi");
        memberToUpdate.setId(savedId);

        // when
        memberDao.update(memberToUpdate);

        // then
        Optional<Member> optionalMember = memberDao.findById(savedId);
        assertThat(optionalMember.isPresent()).isTrue();

        Member result = optionalMember.get();
        assertThat(result.getNickname()).isEqualTo("kimchi");
        assertThat(result.getAge()).isEqualTo(31);
    }

}

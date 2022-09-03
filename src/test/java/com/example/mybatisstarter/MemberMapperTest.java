package com.example.mybatisstarter;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void test() {
        Member member1 = new Member();
        member1.setNickname("babo1");

        Member member2 = new Member();
        member2.setNickname("babo2");

        memberMapper.save(member1);
        memberMapper.save(member2);

        List<Member> members = memberMapper.findAll();

        assertThat(members).hasSize(2);
        assertThat(members).extracting("nickname")
                .containsExactly("babo1", "babo2");
    }

}

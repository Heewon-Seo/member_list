package com.comtrue.work.mapper;

import com.comtrue.work.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    void selectMemberList() {
        List<Member> list = null;
//        Assertions.assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void insertMember() {
        Member member = new Member(4, "대리", "이름1", "010-2222-2222", "name@test.com");
        memberMapper.insertMember(member);
    }
}

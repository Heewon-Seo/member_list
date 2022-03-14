package com.comtrue.work.service;

import com.comtrue.work.domain.member.Member;
import com.comtrue.work.mapper.MemberMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    private MemberMapper mapper;

    @Test
    void viewMemberList() {
        Assertions.assertThat(mapper.selectMemberList()).isEmpty();
    }

    @Test
    void saveMember() {

    }
}

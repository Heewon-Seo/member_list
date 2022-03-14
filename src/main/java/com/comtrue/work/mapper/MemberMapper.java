package com.comtrue.work.mapper;

import com.comtrue.work.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<Member> selectMemberList();

    Member selectMember(Integer id);

    void insertMember(Member member);

    void editMember(Member member);

    void deleteMember(Integer id);

    List<Member> searchMemberList(String keyword);

}

package com.comtrue.work.service;

import com.comtrue.work.domain.member.Member;
import org.springframework.stereotype.Service;

import java.io.Writer;
import java.util.List;

@Service
public interface MemberService {

    public abstract List<Member> viewMemberList();

    public abstract Member viewMember(Integer id);

    public abstract void saveMember(Member member);

    public abstract void editMember(Member member);

    public abstract void deleteMember(Integer id);

    public abstract List<Member> searchMembers(String keyword);

    public abstract void csvDownload(Writer writer);


}

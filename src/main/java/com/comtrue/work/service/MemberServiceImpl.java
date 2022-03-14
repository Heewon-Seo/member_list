package com.comtrue.work.service;

import com.comtrue.work.domain.member.Member;
import com.comtrue.work.mapper.MemberMapper;
import lombok.NoArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@NoArgsConstructor

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper mapper;

    @Override
    public List<Member> viewMemberList() {
        if(!this.mapper.selectMemberList().isEmpty()) {
            return this.mapper.selectMemberList();
        } else {
            return null;
        }
    }

    @Override
    public Member viewMember(Integer id) {
        return this.mapper.selectMember(id);
    }

    @Override
    public void saveMember(Member member) {
        this.mapper.insertMember(member);
    }

    @Override
    public void editMember(Member member) {
        this.mapper.editMember(member);
    }

    @Override
    public void deleteMember(Integer id) {
        this.mapper.deleteMember(id);
    }

    @Override
    public List<Member> searchMembers(String keyword) {
        return this.mapper.searchMemberList(keyword);
    }

    @Override
    public void csvDownload(Writer writer) {
        List<Member> members = this.mapper.selectMemberList();
        try(CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (Member member : members) {
                csvPrinter.printRecord(
                        member.getId(),
                        member.getPosition(),
                        member.getName(),
                        member.getPhoneNumber(),
                        member.getEmail()
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

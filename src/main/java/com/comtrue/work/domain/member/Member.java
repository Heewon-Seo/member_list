package com.comtrue.work.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Member {

    private Integer id;
    private String position;
    private String name;
    private String phoneNumber;
    private String email;

    public Member(Integer id, String position, String name, String phoneNumber, String email) {
        this.id = id;
        this.position = position;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}

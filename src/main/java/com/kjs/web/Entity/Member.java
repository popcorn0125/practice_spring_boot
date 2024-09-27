package com.kjs.web.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Member {
    @Id
    @Column(nullable = false)
    private String member_id;

    @Column(nullable = false)
    private String member_pw;

    @Column(nullable = false)
    private String member_name;
}

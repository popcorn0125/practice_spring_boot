package com.kjs.web.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String car;

    private String image;

    private Integer price; // 객체로 사용하는 이유는 객체에서 지원하는 함수를 사용하기 위해 사용. 스프링 권장 사항이다.

    @Column(length = 100)
    private String manufacturing_company;

    @Column(columnDefinition = "TEXT")
    private String explanation;

    private LocalDate release_date; // 년도 월 일 까지 형식에 맞추어 생성함.
}

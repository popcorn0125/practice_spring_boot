package com.ksj.practice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(columnDefinition = "TEXT")
    public String image;

    @Column(nullable = false, unique = true)
    public String car;

    public Integer price;

    @Column(length = 100)
    public String manufacturing_company;

    @Column(columnDefinition = "TEXT")
    public String explanation;

    public LocalDate release_date;
}

package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //MySQL이므로 타입은 저것.
    private Long id;

    private String name;

    private Integer price;

    private String content;


}

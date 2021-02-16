package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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


    //1 : N

    // LAZY = 지연로딩 ㄴ, EAGERR = 즉시로딩
    @OneToMany(fetch =  FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orederDetailList;

}
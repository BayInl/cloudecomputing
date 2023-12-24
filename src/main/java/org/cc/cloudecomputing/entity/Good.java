package org.cc.cloudecomputing.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "good")
@Data
public class Good {
    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "uid", nullable = false)
    private int uid;

    @Column(name = "sales", columnDefinition = "int comment '销量'")
    private Integer sales;

    @Column(name = "stockpile", columnDefinition = "int comment '库存'")
    private Integer stockpile;

    @Column(name = "price", nullable = false, precision = 9, scale = 2, columnDefinition = "decimal(9,2) comment '价格'")
    private BigDecimal price;

    @Column(name = "main", nullable = false)
    private String main;

    @Column(name = "detail", nullable = false)
    private String detail;

    @Column(name = "img", length = 1023)
    private String img;
}

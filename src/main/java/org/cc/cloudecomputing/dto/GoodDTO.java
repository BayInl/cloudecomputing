package org.cc.cloudecomputing.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class GoodDTO implements Serializable {
    private String name;
    private Integer uid;
    private Integer sales;
    private Integer stockpile;
    private BigDecimal price;
    private String main;
    private String detail;
    private String img;
    public GoodDTO(){}
    public GoodDTO(String name,Integer uid,Integer sales,Integer stockpile,BigDecimal price,String main,String detail,String img){
        this.name=name;
        this.uid=uid;
        this.sales=sales;
        this.stockpile=stockpile;
        this.price=price;
        this.main=main;
        this.detail=detail;
        this.img=img;
    }
    @Override
    public String toString() {
        return "GoodDTO{" +
                "name='" + name + '\'' +
                ", uid=" + uid +
                ", sales=" + sales +
                ", stockpile=" + stockpile +
                ", price=" + price +
                ", main='" + main + '\'' +
                ", detail='" + detail + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof GoodDTO goodDTO){
            return this.name.equals(goodDTO.name)&&this.uid.equals(goodDTO.uid)&&this.sales.equals(goodDTO.sales)&&this.stockpile.equals(goodDTO.stockpile)&&this.price.equals(goodDTO.price)&&this.main.equals(goodDTO.main)&&this.detail.equals(goodDTO.detail)&&this.img.equals(goodDTO.img);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return this.name.hashCode()+this.uid.hashCode()+this.sales.hashCode()+this.stockpile.hashCode()+this.price.hashCode()+this.main.hashCode()+this.detail.hashCode()+this.img.hashCode();
    }
}

package org.cc.cloudecomputing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import org.cc.cloudecomputing.entity.MultiPK.CategoryPK;
import jakarta.persistence.Id;
@Data
@Entity
@Table(name = "category")
@IdClass(CategoryPK.class)
public class Category {
    @Id
    @Column(name = "main")
    private String Main;
    @Id
    @Column(name = "detail")
    private String Detail;
    public Category() {}
    public Category(String main, String detail) {
        this.Main = main;
        this.Detail = detail;
    }
}

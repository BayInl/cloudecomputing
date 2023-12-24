package org.cc.cloudecomputing.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.cc.cloudecomputing.entity.MultiPK.OrdersPK;

import java.util.Date;

@Entity
@Table(name = "orders")
@IdClass(OrdersPK.class)
@Data
public class Orders {
    @Id
    @Column(name="uid", nullable = false)
    private Integer uid;

    @Id
    @Column(name="name", nullable = false)
    private String name;

    @Id
    @Column(name="date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name="quantity", nullable = false)
    private int quantity;

    public Orders() {
    }

    public Orders(int uid, String name, Date date, int quantity) {
        this.uid = uid;
        this.name = name;
        this.date = date;
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Orders{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", quantity=" + quantity +
                '}';
    }

}

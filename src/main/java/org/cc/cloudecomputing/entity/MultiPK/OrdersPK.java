package org.cc.cloudecomputing.entity.MultiPK;
import java.util.Date;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class OrdersPK implements Serializable {
    private Integer uid;
    private String name;
    private Date date;
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OrdersPK pk) {
            return Objects.equals(uid, pk.uid) && name.equals(pk.name) && date.equals(pk.date);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return uid.hashCode() + name.hashCode() + date.hashCode();
    }
    @Override
    public String toString() {
        return uid + "-" + name + "-" + date;
    }
    public OrdersPK() {
    }
    public OrdersPK(int uid, String name, Date date) {
        this.uid = uid;
        this.name = name;
        this.date = date;
    }
}

package org.cc.cloudecomputing.entity.MultiPK;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class CategoryPK implements Serializable {
    private String main;
    private String detail;
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CategoryPK pk) {
            return main.equals(pk.main) && detail.equals(pk.detail);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return main.hashCode() + detail.hashCode();
    }
    @Override
    public String toString() {
        return main + "-" + detail;
    }
}

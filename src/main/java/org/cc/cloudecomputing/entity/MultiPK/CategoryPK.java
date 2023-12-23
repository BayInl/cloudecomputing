package org.cc.cloudecomputing.entity.MultiPK;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryPK implements Serializable {
    private String Main;
    private String Detail;
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CategoryPK pk) {
            return Main.equals(pk.Main) && Detail.equals(pk.Detail);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Main.hashCode() + Detail.hashCode();
    }
    @Override
    public String toString() {
        return Main + "-" + Detail;
    }
}

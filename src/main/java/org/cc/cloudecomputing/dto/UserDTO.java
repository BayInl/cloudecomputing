package org.cc.cloudecomputing.dto;

import lombok.Data;
import org.cc.cloudecomputing.entity.User;

import java.io.Serializable;
@Data
public class UserDTO implements Serializable {
    private String name;
    private String passwd;
    private long phone;
    public UserDTO(){}
    public UserDTO(String name,String passwd,int phone){
        this.name=name;
        this.passwd=passwd;
        this.phone=phone;
    }
    public UserDTO(String name,String passwd){
        this.name=name;
        this.passwd=passwd;
    }
    public UserDTO(User user){
        this.name=user.getName();
        this.passwd=user.getPasswd();
        this.phone=user.getPhone();
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", phone=" + phone +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof UserDTO userDTO){
            return this.name.equals(userDTO.name)&&this.passwd.equals(userDTO.passwd)&&this.phone==userDTO.phone;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+this.passwd.hashCode()+Long.valueOf(this.phone).hashCode();
    }


}

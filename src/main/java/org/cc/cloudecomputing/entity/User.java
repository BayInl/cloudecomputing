package org.cc.cloudecomputing.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "passwd", nullable = false)
    private String passwd;

    @Column(name="phone")
    private long phone;

    @Column(name="role")
    private String role;

    @PrePersist
    public void prePersist() {
        if (role == null) {
            role = "user";
        }
    }

}

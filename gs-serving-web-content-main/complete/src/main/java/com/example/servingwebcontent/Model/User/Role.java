package com.example.servingwebcontent.Model.User;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;  // Ví dụ: "ROLE_ADMIN", "ROLE_HOCSINH"

    @ManyToMany(mappedBy = "roles")
    private Set<TaiKhoan> taiKhoans;  // Liên kết ngược với TaiKhoan

    // Constructors
    public Role() {}

    public Role(String name) {
        setName(name);  // Dùng setter để validation
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.startsWith("ROLE_")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Tên role phải bắt đầu bằng 'ROLE_' (ví dụ: ROLE_ADMIN)");
        }
    }

    public Set<TaiKhoan> getTaiKhoans() {
        return taiKhoans;
    }

    public void setTaiKhoans(Set<TaiKhoan> taiKhoans) {
        this.taiKhoans = taiKhoans;
    }

    @Override
    public String toString() {
        return "Role{name='" + name + "'}";
    }
}
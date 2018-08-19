package com.huang.security.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="RoleSequence")
    @SequenceGenerator(name="RoleSequence",sequenceName="role_seq",allocationSize=1)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<User>();
    @ManyToMany
    @JoinTable(name = "tb_role_per", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "per_id"))
    private List<Permission> permissions = new ArrayList<Permission>();
}

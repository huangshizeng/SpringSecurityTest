package com.huang.security.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_per")
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="PerSequence")
    @SequenceGenerator(name="PerSequence",sequenceName="per_seq",allocationSize=1)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles = new ArrayList<Role>();
}

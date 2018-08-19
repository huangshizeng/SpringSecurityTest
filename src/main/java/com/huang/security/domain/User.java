package com.huang.security.domain;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Log
@Entity
@Table(name = "tb_user")
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="UserSequence")
    @SequenceGenerator(name="UserSequence",sequenceName="user_seq",allocationSize=1)
    private Long id;
    private String username;
    private String password;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "tb_user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<Role>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<Role> roleList = this.getRoles();
        log.info("" + roleList.size());
        for (Role role : roleList) {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

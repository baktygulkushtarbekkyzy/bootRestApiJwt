package com.example.bootrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "auth_infos")
@Getter
@Setter
@NoArgsConstructor
public class AuthInfo implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "auth_info_gen")
    @SequenceGenerator(name = "auth_info_gen",sequenceName = "auth_info_seq",allocationSize = 1)
    private Long id;

    private String email;
    private String password;
    @Column(name = "is_account_non_locked")
    private boolean isAccountNonLocked=true;


    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinTable(name = "authInfo_roles",
    joinColumns = @JoinColumn(name = "authInfo_id"),
    inverseJoinColumns = @JoinColumn(name = "roles_id"))
    @JsonIgnore
    private List<Role> roles=new ArrayList<>();


    public void addAuthInfo(Role role){
        if (roles==null){
            roles=new ArrayList<>();
        }
        roles.add(role);
        role.addAuthInfo(this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.synchronizedCollection(roles);
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
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

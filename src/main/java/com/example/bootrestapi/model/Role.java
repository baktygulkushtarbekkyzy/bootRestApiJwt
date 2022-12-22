package com.example.bootrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "roles")
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "role_gen")
    @SequenceGenerator(name = "role_gen",sequenceName = "role_seq",allocationSize = 1)
    private Long id;

    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH} , fetch = FetchType.EAGER, mappedBy = "roles")
    @JsonIgnore
    private List<AuthInfo> authInfos;


    public void addAuthInfo(AuthInfo authInfo){
        if (authInfos==null){
            authInfos=new ArrayList<>();
        }
        authInfos.add(authInfo);
    }


    @Override
    public String getAuthority() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}

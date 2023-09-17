package com.memoria_colectiva.api.models.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.UniqueConstraint;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long id;

    @Column(name="usu_username")
    private String username;
    
    @Column(name="usu_password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name="usuario_authority", 
        joinColumns= @JoinColumn(name="usu_id",  referencedColumnName ="usu_id"),
    	inverseJoinColumns=@JoinColumn(name="aut_id",  referencedColumnName ="aut_id"),
        // uniqueConstraints= {@UniqueConstraint(columnNames= {"usu_id", "aut_id"})},
        foreignKey=@ForeignKey(name = "fk_usu_aut")
        )
    private List<Authority> authorities;

	public Usuario(String username, String password, List<Authority> authorities) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
    
    
}

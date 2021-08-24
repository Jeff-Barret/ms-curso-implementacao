package com.microservico.hruser.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String name;
	
	@Column(unique = true)
	private String email;
	private String password;
	
	@ManyToMany (fetch = FetchType.EAGER)// É quando eu quero que os dados dos perfis sejam automaticamente carregados já junto com o usuario.
	@JoinTable(name = "tb_user_role",
		joinColumns = @JoinColumn(name = "user_id"), // Anotação para informar qual a chave estrangeira em referencia a propria tabela de classe onde eu estou
		inverseJoinColumns = @JoinColumn(name = "role_id") //Anotação referente ao nome da chave estrangeira que referencia a outra tabela, no caso a tabela de Roles, a tabela que esta do outro lado.
			)
	
	Set<Role> roles = new HashSet<>();  // Uma coleção que reprensta conjunto, ela não aceitar repetição do mesmo valor 
									    // O sett é uma interface então eu tenho que instanciar com uma classe que implementa a interface, que no caso é o HashSet
	
	public User() {
	}

	public User(Long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, password);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}

	
}

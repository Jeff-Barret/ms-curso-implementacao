package com.microservico.hroauth.entities;

import java.io.Serializable;
import java.util.Objects;


public class Role implements Serializable{ 
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String roleName;
	
	public Role(){
		
	}

	public Role(Long id, String roleName) {
		super();
		this.id = id; 
		this.roleName = roleName;
	}

	public Long getOd() {
		return id;
	}

	public void setOd(Long od) {
		this.id = od;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(id, other.id) && Objects.equals(roleName, other.roleName);
	}
	
	
}

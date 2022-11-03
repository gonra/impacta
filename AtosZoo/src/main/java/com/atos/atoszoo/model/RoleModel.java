package com.atos.atoszoo.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

import com.atos.atoszoo.enums.RoleName;

@Entity
@Table(name = "TBL_ROLE")
public class RoleModel implements GrantedAuthority, Serializable{

	private static final long serialVersionUID = 9L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID roleId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private RoleName roleName;
	
	public UUID getRoleId() {
		return roleId;
	}

	public void setRoleId(UUID roleId) {
		this.roleId = roleId;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.roleName.toString() ;
	}

}

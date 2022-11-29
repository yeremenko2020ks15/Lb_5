package com.example.accessingdatamysql;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String NickName;
	private String Email;
	private String Password;
	@Column(unique = true)
	private String UserRole;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Roles roles;

	public Users() {
	}

	public Users(String nickName, String email, String password, String userRole, Roles roles) {
		this.NickName = nickName;
		this.Email = email;
		this.Password = password;
		this.UserRole = userRole;
		this.roles = roles;
	}
}
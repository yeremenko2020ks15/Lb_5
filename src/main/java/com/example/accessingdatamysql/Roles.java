package com.example.accessingdatamysql;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Roles implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name_role;
	private int count_request;

	@OneToMany(mappedBy = "UserRole", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private Set<Users> users;

	public Roles() {
	}

	public Roles(String name_role, int count_request) {
		this.name_role = name_role;
		this.count_request = count_request;
	}
}
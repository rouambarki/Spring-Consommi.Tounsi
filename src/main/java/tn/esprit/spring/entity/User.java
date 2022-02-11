package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id;
	private String username;
	private String email;
	private String password;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set< Search > Search;
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
	public Set<Search> getSearch() {
		return Search;
	}
	public void setSearch(Set<Search> search) {
		Search = search;
	}
	public User(Long id, String username, String email, String password, Set<Search> search) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		Search = search;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}

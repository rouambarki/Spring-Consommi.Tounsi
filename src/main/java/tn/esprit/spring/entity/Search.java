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
public class Search implements Serializable {
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue (strategy=GenerationType.AUTO)
private Long id_search;
private String word_search;
private int id_clientSearch;
@ManyToMany(mappedBy="Search", cascade = CascadeType.ALL)
private Set<User> User;

public Long getId_search() {
	return id_search;
}
public void setId_search(Long id_search) {
	this.id_search = id_search;
}
public String getWord_search() {
	return word_search;
}
public void setWord_search(String word_search) {
	this.word_search = word_search;
}
public int getId_clientSearch() {
	return id_clientSearch;
}
public void setId_clientSearch(int id_clientSearch) {
	this.id_clientSearch = id_clientSearch;
}
public Set<User> getUser() {
	return User;
}
public void setUser(Set<User> user) {
	User = user;
}

public Search(Long id_search, String word_search, int id_clientSearch, Set<User> user
		) {
	super();
	this.id_search = id_search;
	this.word_search = word_search;
	this.id_clientSearch = id_clientSearch;
	User = user;
	
}
public Search() {
	super();
	// TODO Auto-generated constructor stub
}
public Search(String word_search, int id_clientSearch) {
	super();
	this.word_search = word_search;
	this.id_clientSearch = id_clientSearch;
}





}

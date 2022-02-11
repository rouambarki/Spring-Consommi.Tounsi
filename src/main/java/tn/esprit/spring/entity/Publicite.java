package tn.esprit.spring.entity;

import java.io.Serializable;

import java.util.Date;


import javax.persistence.*;
@Entity
public class Publicite implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private long id_adds;
	private String add_name;
	private String canal;
	@Temporal (TemporalType.DATE)
	private Date date_start;
	@Temporal (TemporalType.DATE)
	private Date date_finish;
	private String add_content;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String add_picture;
	
	
	
	public long getId_adds() {
		return id_adds;
	}
	public void setId_adds(long id_adds) {
		this.id_adds = id_adds;
	}
	public String getAdd_name() {
		return add_name;
	}
	public void setAdd_name(String add_name) {
		this.add_name = add_name;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public Date getDate_start() {
		return date_start;
	}
	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}
	public Date getDate_finish() {
		return date_finish;
	}
	public void setDate_finish(Date date_finish) {
		this.date_finish = date_finish;
	}
	public String getAdd_content() {
		return add_content;
	}
	public void setAdd_content(String add_content) {
		this.add_content = add_content;
	}
	public String getAdd_picture() {
		return add_picture;
	}
	public void setAdd_picture(String add_picture) {
		this.add_picture = add_picture;
	}
	
	
	public Publicite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publicite(long id_adds, String add_name, String canal, Date date_start, Date date_finish, String add_content,
			String add_picture) {
		super();
		this.id_adds = id_adds;
		this.add_name = add_name;
		this.canal = canal;
		this.date_start = date_start;
		this.date_finish = date_finish;
		this.add_content = add_content;
		this.add_picture = add_picture;
		
		
	}
	public Publicite(String add_name, String add_content, String add_picture) {
		super();
		this.add_name = add_name;
		this.add_content = add_content;
		this.add_picture = add_picture;
	}
	



	
	

}

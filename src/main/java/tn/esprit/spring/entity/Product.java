package tn.esprit.spring.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_product;
	private String Name_product;
	private String Description;
	private String Type;
	private String Catégorie;
	private int Quantity;
	private int Price;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String Picture;
	private String Code_barre;
	
	public Long getId_product() {
		return id_product;
	}
	public void setId_product(Long id_product) {
		this.id_product = id_product;
	}
	public String getName_product() {
		return Name_product;
	}
	public void setName_product(String name_product) {
		Name_product = name_product;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getCatégorie() {
		return Catégorie;
	}
	public void setCatégorie(String catégorie) {
		Catégorie = catégorie;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}
	public String getCode_barre() {
		return Code_barre;
	}
	public void setCode_barre(String code_barre) {
		Code_barre = code_barre;
	}
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long id_product, String name_product, String description, String type, String catégorie,
			int quantity, int price, String picture, String code_barre) {
		super();
		this.id_product = id_product;
		Name_product = name_product;
		Description = description;
		Type = type;
		Catégorie = catégorie;
		Quantity = quantity;
		Price = price;
		Picture = picture;
		Code_barre = code_barre;
		
	}
	public Product(String code_barre) {
		super();
		Code_barre = code_barre;
	}
	@Override
	public String toString() {
		return "Product [Name_product=" + Name_product + "]";
	}

	
	

}
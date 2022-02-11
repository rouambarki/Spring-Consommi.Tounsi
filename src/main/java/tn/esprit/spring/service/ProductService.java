package tn.esprit.spring.service;

import java.util.List;


import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.entity.Product;

public interface ProductService {
	public void  saveProductToDB(MultipartFile file,String Name_product,String Description,String Type,String Catégorie,
			int Quantity,int Price,String Code_barre);
	public List<Product> getAllProduct();
	 public void deleteProductById(Long id);
	 public Product getProductbyid(Long id);
	 public Product updateProduct(Product Product );
	 public void chageProductName(Long id ,String name);
	 public void changeProductDescription(Long id , String description);
	 public void changeProductPrice(Long id,int price);
	
	
}

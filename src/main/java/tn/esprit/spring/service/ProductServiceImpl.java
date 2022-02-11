package tn.esprit.spring.service;

import java.io.IOException;


import java.util.Base64;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.repository.ProductRepository;


@Service 
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	public void  saveProductToDB(MultipartFile file,String Name_product,String Description,String Type,String Catégorie,
			int Quantity,int Price,String Code_barre)
	{
		Product p = new Product();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		p.setPicture(file.getOriginalFilename());
		p.setName_product(Name_product);
		p.setDescription(Description);
		 p.setType(Type);
		p.setCode_barre(Code_barre);
		p.setCatégorie(Catégorie);
        p.setQuantity(Quantity);
        p.setPrice(Price);
        
        
        
        
        productRepo.save(p);
	}
	@Override
	public List<Product> getAllProduct()
	{        
		return  (List<Product>)productRepo.findAll();
	}
	@Override
    public void deleteProductById(Long id)
    {
    	productRepo.deleteById(id);
    }
	@Override
    public void chageProductName(Long id ,String name)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setName_product(name);
    	productRepo.save(p);    
    }
	@Override
    public void changeProductDescription(Long id , String description)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setDescription(description);
    	productRepo.save(p);
    }
	@Override
    public void changeProductPrice(Long id,int price)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setPrice(price);
    	productRepo.save(p);
    }
	@Override
	public Product getProductbyid(Long id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}
	@Override
	public Product updateProduct(Product Product) {
		// TODO Auto-generated method stub
		return productRepo.save(Product);
	}
	
	
    	
	
}

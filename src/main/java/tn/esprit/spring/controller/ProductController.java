package tn.esprit.spring.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.entity.Search;
import tn.esprit.spring.repository.SearchRepository;

import java.awt.Graphics2D;



	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import javax.imageio.ImageIO;

	
	import net.sourceforge.tess4j.ITesseract;
	import net.sourceforge.tess4j.Tesseract;
	import net.sourceforge.tess4j.TesseractException;
import tn.esprit.spring.entity.Publicite;
import tn.esprit.spring.entity.Product;


import tn.esprit.spring.service.ProductService;



	@RestController
	public class ProductController {
		
		@Autowired
		private ProductService productService;
		@Autowired
		private ProductService  productreimpl;
		@Autowired 
		SearchRepository SearchRepository ;
		@Autowired 
		ProductRepository ProductRepository ;
		
		
		@GetMapping("/listProducts")
		public List<Product> findallProducts() {
			
			return productService.getAllProduct( );
			
			
			
		}
		
		

		@PostMapping("Post-Product")

		public String DoOCR(
				@RequestParam("Code_barre") MultipartFile image,@RequestParam("Picture") MultipartFile Picture,
				@RequestParam("Type") String Type,
	    		@RequestParam("Name") String Name_product,
	    		@RequestParam("Price") int Price,@RequestParam("Catégorie") String Catégorie,
	    		@RequestParam("Description") String Description,@RequestParam("Quantity") int Quantity) throws IOException {

			
			OcrModel request = new OcrModel();
			
			request.setImage(image);

			ITesseract instance = new Tesseract();

			try {
				
				BufferedImage in = ImageIO.read(convert(image));

				BufferedImage newImage = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_ARGB);
	            
				Graphics2D g = newImage.createGraphics();
				g.drawImage(in, 0, 0, null);
				g.dispose();
	            
			
				instance.setDatapath("C:/Users/User/Documents/workspace-sts-3.8.4.RELEASE/CrudProducts/tessdata");

				String result = instance.doOCR(newImage);

				if (result.startsWith("6\"" +" "+"19"))
					
				{
					//ProductRepository.change();
					productreimpl.saveProductToDB(Picture,Name_product,Description, Type, Catégorie,Quantity, Price,result);
					
					return "le produit est tounsi  l'ajout avec succes";
					
				
				}
				else {
					
					return "le produit non tounsi!!! ";
				}
				
				

			} catch (TesseractException | IOException e) {
				System.err.println(e.getMessage());
				
			}
			return null;

		}
		
		public static File convert(MultipartFile file) throws IOException {
		    File convFile = new File(file.getOriginalFilename());
		    convFile.createNewFile();
		    FileOutputStream fos = new FileOutputStream(convFile);
		    fos.write(file.getBytes());
		    fos.close();
		    return convFile;
		}
		@PutMapping(value="update-Product")
		public Product updateAdds(@RequestBody Product Product){
			return productService.updateProduct(Product);
		}
		
		@DeleteMapping(value="delete-product")
		public String  deleteProduct(@RequestParam Long id) {
			productService.deleteProductById(id);
			return ( "le produit avec l'id"+id+"est supprimè");
			
			
		}
		
		
		@GetMapping("list/{id}")
		public Product getlistbyif(@PathVariable Long id){
			return productService.getProductbyid(id);
			
			
			
		}
		@GetMapping("lis/{Name_product}")
		
	    public List<Product> searchbyTypeOrName(@PathVariable String Name_product ,String Type,@RequestParam int id_client ){
			Search Search = new Search(Name_product,id_client) ;
			SearchRepository.save(Search);
			return ProductRepository.findUserByNameOrType(Name_product,Type);
			
			
	 	}
		@GetMapping("nbProducts")
		 public String CountProducts(){
			int a=  ProductRepository.NBPRODUCTS();
			int b= ProductRepository.NBADDS();
			return "les nombres des clients est "+a+"/n les nombres des publicites est "+b ;
		}
		
		
		
		   



}

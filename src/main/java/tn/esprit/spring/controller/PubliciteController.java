package tn.esprit.spring.controller;

import java.util.Date;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Publicite;
import tn.esprit.spring.service.PubliciteServiceImpl;
import tn.esprit.spring.repository.PubliciteRepository;




@RestController
@CrossOrigin("*")
public class PubliciteController {
	@Autowired
	PubliciteServiceImpl addsserviceimpl;
	@Autowired
	PubliciteRepository AddsRepository;
	
	@PostMapping(value="save-adds")
	public String saveAdds(@RequestParam("Picture") MultipartFile file,@RequestParam("Name")String add_name, @RequestParam("canal")String canal, @RequestParam("D-start") Date date_start,@RequestParam("D-finish") Date date_finish,
			 @RequestParam("add_content")String add_content) {
		addsserviceimpl.saveAdds( file, add_name, canal,date_start, date_finish, add_content);
		return "ajoutsucces" ;
	 }
	@GetMapping(value="get-adds")
	public List<Publicite> findallProducts() {
		return addsserviceimpl.findallAdds();
	}
	@PutMapping(value="update-adds")
	public Publicite updateAdds(@RequestBody Publicite Adds){
		return addsserviceimpl.updateAdds(Adds);
	}
	@DeleteMapping(value="delete-adds")
	public String  deleteAdds(@RequestParam int id) {
		addsserviceimpl.deleteAdds(id);
		return ( "le produit avec l'id "+id+"est supprimè");
		
		
	}
@GetMapping("AddsForclient/{id}")
	
    public List<Publicite> searchbyTypeOrName(@PathVariable long id  ){
	  
		
		return AddsRepository.lespubquiaffichepourceclient(id);
		
		
 	}

}

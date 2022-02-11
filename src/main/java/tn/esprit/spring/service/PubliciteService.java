package tn.esprit.spring.service;

import java.util.Date;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Publicite;



public interface PubliciteService {
		///save product
		public Publicite saveAdds(MultipartFile file,String add_name, String canal, Date date_start, Date date_finish,String add_content );
		///update
		public Publicite updateAdds(Publicite Adds );
	    ////fetch
		public List<Publicite>  findallAdds();
	    //// delete product
		public void deleteAdds(long id);
	}



package tn.esprit.spring.service;

import java.io.IOException;



import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Publicite;
import tn.esprit.spring.repository.PubliciteRepository;


@Service
public class PubliciteServiceImpl  implements PubliciteService{
	@Autowired 
	PubliciteRepository addsrep ;
	@Override
	public Publicite saveAdds(MultipartFile file,String add_name, String canal, Date date_start, Date date_finish,String add_content)
	{
		Publicite p = new Publicite();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		p.setAdd_picture(file.getOriginalFilename());
        p.setAdd_name(add_name);	
        p.setCanal(canal); 
        p.setDate_start(date_start);
        p.setDate_finish(date_finish);	 
        p.setAdd_content( add_content);
        
        
	return	(addsrep.save(p));
	}
	

	@Override
	public Publicite updateAdds(Publicite Adds) {
		// TODO Auto-generated method stub
		return (addsrep.save(Adds));
	}

	@Override
	public List<Publicite> findallAdds() {
		// TODO Auto-generated method stub
		return (List<Publicite>)addsrep.findAll();
	}

	@Override
	public void deleteAdds(long id) {
		// TODO Auto-generated method stub
		addsrep.deleteById(id);
	}


	


	
}

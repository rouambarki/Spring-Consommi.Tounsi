package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Publicite;

@Repository

public interface PubliciteRepository extends CrudRepository<Publicite, Long> {
	@Query(value = "SELECT * FROM  publicite  JOIN Search JOIN User  where (Search.word_search=publicite.add_name OR Search.word_search=publicite.add_content )AND( User.id=Search.id_client_Search)  AND (User.id = ?1)   ", nativeQuery = true)
    List<Publicite> lespubquiaffichepourceclient(@Param("id") long id);



}

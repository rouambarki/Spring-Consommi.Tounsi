package tn.esprit.spring.repository;

import org.springframework.stereotype.Repository;



import tn.esprit.spring.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
@Repository
public interface ProductRepository extends CrudRepository<Product,Long>
{
	@Query(value = "SELECT * FROM Product  where Name_product = ?1 OR Type= ?1 ORDER BY id_product ASC", nativeQuery = true)
    List<Product> findUserByNameOrType(@Param("Name_product")String Name_product,@Param("Type")String Type);
	//@Modifying
	//@Query(value = " UPDATE Product SET Catégorie = 'Santè'  where Type = 'ord' ", nativeQuery = true)
    //public void change();
	@Query(value = "SELECT COUNT(*) FROM Product  ", nativeQuery = true)
    public int NBPRODUCTS();
	@Query(value = "SELECT COUNT(*) FROM publicite  ", nativeQuery = true)
	public int NBADDS();
	
	
	

}

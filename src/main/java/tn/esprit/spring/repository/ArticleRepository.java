package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.entity.Type;



@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	List<Article> findByCategorie(Categorie cat);
	List<Article> findByType(Type type);
	
	@Query("Select r FROM Article r where r.categorie =:categorie AND r.type =:type")
	List<Article> recherchepartypeetcategorie(@Param("categorie") tn.esprit.spring.entity.Categorie categorie ,@Param("type") tn.esprit.spring.entity.Type type
			);
	List<Article> findByName(String name);

}

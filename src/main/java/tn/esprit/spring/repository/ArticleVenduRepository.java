package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.ArticleVendu;


@Repository
public interface ArticleVenduRepository extends JpaRepository<ArticleVendu, Long> {

}

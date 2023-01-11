package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.ArticleVendu;
import tn.esprit.spring.entity.Commande;

public interface IArticleVenduserv {
	public ArticleVendu ajouteretArticlevendu(Long articlesid,ArticleVendu av);
	public void supprimerarticlevendu(List<Long> idav);
	public List<ArticleVendu> getall();

}

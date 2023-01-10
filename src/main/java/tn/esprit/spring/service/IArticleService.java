package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.entity.Type;

public interface IArticleService {
	public Article ajoutArticle(Article article);
	public Article updateArticle(Article article,Long idarticle);
	public void deleteArticle(Long idarticle);
	public Article affichDetailarticle(Long idarticle);
	public List<Article> getAllArticle();
	public List<Article> getArticleByCategorie(Categorie categorie);
	public List<Article> getArticleByType(Type type);
	public List<Article> getArticleParTypeEtCategorie(Type type,Categorie categorie);

}

package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.entity.Type;
import tn.esprit.spring.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements IArticleService {
	@Autowired
	ArticleRepository articleRepo;

	@Override
	public Article ajoutArticle(Article article) {
		
		return articleRepo.save(article);
	}

	@Override
	public Article updateArticle(Article article, String idarticle) {
		Article a=articleRepo.findById(idarticle).orElse(null);
		a.setCategorie(article.getCategorie());
		a.setDescription(article.getDescription());
		a.setPrix(article.getPrix());
		a.setType(article.getType());
		return articleRepo.save(a);
	}

	@Override
	public void deleteArticle(String idarticle) {
		articleRepo.deleteById(idarticle);
		
	}

	@Override
	public List<Article> getAllArticle() {
		
		return articleRepo.findAll();
	}

	@Override
	public List<Article> getArticleByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return articleRepo.findByCategorie(categorie);
	}

	@Override
	public List<Article> getArticleByType(Type type) {
		// TODO Auto-generated method stub
		return articleRepo.findByType(type);
	}

	@Override
	public List<Article> getArticleParTypeEtCategorie(Type type, Categorie categorie) {
		// TODO Auto-generated method stub
		return articleRepo.recherchepartypeetcategorie(categorie, type);
	}

}

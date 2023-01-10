package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.ArticleVendu;
import tn.esprit.spring.repository.ArticleRepository;
import tn.esprit.spring.repository.ArticleVenduRepository;

@Service
public class ArticleVenduservImpl implements IArticleVenduserv {

	@Autowired
	ArticleRepository articleRepo;
	@Autowired
	ArticleVenduRepository articlevendurepo;
	
	@Override
	public ArticleVendu ajouteretArticlevendu(Long articlesid,ArticleVendu av) {
		Article a = articleRepo.findById(articlesid).orElse(null);
		av.setArticle(a);
		return articlevendurepo.save(av);
	}

	@Override
	public void supprimerarticlevendu(List<Long> idav) {
		for(Long id :idav) {
			articlevendurepo.deleteById(id);
		}
		
		
	}

}

package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.ArticleVendu;
import tn.esprit.spring.service.ArticleVenduservImpl;



@CrossOrigin(origins = "http://localhost:4200/",exposedHeaders="Access-Control-Allow-Origin" )
@RestController
@RequestMapping("/articlevendu")
public class ArticleVenduController {
	@Autowired
	ArticleVenduservImpl articlevenduServ;
	
	@PostMapping("/add-articlevendu/{idarticle}")
	@ResponseBody
	public ArticleVendu addcentre(@RequestBody ArticleVendu av,@PathVariable("idarticle") Long idarticle)
	{
		return articlevenduServ.ajouteretArticlevendu(idarticle,av);
	
	}
	@DeleteMapping("/delete-articlevendu/{idarticlevendu}")
	@ResponseBody
	public void deleteArticle(@PathVariable("idarticlevendu") List<Long> idarticle)
	{
		articlevenduServ.supprimerarticlevendu(idarticle);
	
	}

}

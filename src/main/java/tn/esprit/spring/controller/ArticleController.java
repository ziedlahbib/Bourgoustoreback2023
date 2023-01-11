package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.entity.Type;
import tn.esprit.spring.service.ArticleServiceImpl;
@CrossOrigin(origins = "http://localhost:4200/",exposedHeaders="Access-Control-Allow-Origin" )
@RestController
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	ArticleServiceImpl articleServ;
	
	@PostMapping("/add-article")
	@ResponseBody
	public Article addcentre(@RequestBody Article a)
	{
		return articleServ.ajoutArticle(a);
	
	}
	@PutMapping("/update-article/{idarticle}")
	@ResponseBody
	public Article updateArticle(@RequestBody Article a,@PathVariable("idarticle") Long idarticle)
	{
		return articleServ.updateArticle(a, idarticle);
	
	}
	
	@DeleteMapping("/delete-article/{idarticle}")
	@ResponseBody
	public void deleteArticle(@PathVariable("idarticle") Long idarticle)
	{
		articleServ.deleteArticle(idarticle);
	
	}
	@GetMapping("/get-article/{id-article}")
	@ResponseBody
	public Article getuserbyid(@PathVariable("id-article") Long idArticle) {
		return articleServ.affichDetailarticle(idArticle);

	}
	@GetMapping("/get-all-article")
	@ResponseBody
	public List<Article> affichetallArticle()
	{
		return articleServ.getAllArticle();
	
	}
	@GetMapping("/get-article-by-categorie/{categorie}")
	@ResponseBody
	public List<Article> affichArticleByCategorie(@PathVariable("categorie") Categorie categorie)
	{
		return articleServ.getArticleByCategorie(categorie);
	
	}
	
	@GetMapping("/get-article-by-type/{type}")
	@ResponseBody
	public List<Article> affichArticleBytype(@PathVariable("type") Type type)
	{
		return articleServ.getArticleByType(type);
	
	}
	@GetMapping("/get-article-by-name/{name}")
	@ResponseBody
	public List<Article> affichArticleByName(@PathVariable("name") String name)
	{
		return articleServ.getArticleByName(name);
	
	}
	@GetMapping("/get-article-by-categorie-ET-Type/{categorie}/{type}")
	@ResponseBody
	public List<Article> affichArticleByCategorieEtType(@PathVariable("categorie") Categorie categorie,@PathVariable("type") Type type)
	{
		return articleServ.getArticleParTypeEtCategorie(type, categorie);
	
	}
	
	

}

package tn.esprit.spring.service;

import tn.esprit.spring.entity.Commande;

import java.util.List;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.ArticleVendu;

public interface ICommandeserv {
	public Commande ajouteretAffecterArticle(List<ArticleVendu> articles,Commande cmd,Long iduser);

}

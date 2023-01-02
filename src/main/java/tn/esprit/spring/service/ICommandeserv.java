package tn.esprit.spring.service;

import tn.esprit.spring.entity.Commande;

import java.util.List;

import tn.esprit.spring.entity.Article;

public interface ICommandeserv {
	public Commande ajouteretAffecterArticle(List<String> articles,Commande cmd,Long iduser);

}

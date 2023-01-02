package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.service.CommandeServiceImpl;





@RestController
@RequestMapping("/commande")

public class CommandeController {
	
	@Autowired
	CommandeServiceImpl cmdServ;
	@PostMapping("/add-Commande/{idArticle}/{iduser}")
	public void ajoutercomandeetuserEtAffecterArticleaucommande(@RequestBody Commande cmd, @PathVariable("idArticle")List<String> idArticle,@PathVariable("iduser")Long iduser){
		cmdServ.ajouteretAffecterArticle(idArticle, cmd,iduser);
	}

}

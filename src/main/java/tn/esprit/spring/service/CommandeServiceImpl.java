package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.ArticleVendu;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ArticleRepository;
import tn.esprit.spring.repository.ArticleVenduRepository;
import tn.esprit.spring.repository.CommandeRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class CommandeServiceImpl implements ICommandeserv{

	@Autowired
	ArticleRepository articleRepo;
	@Autowired
	ArticleVenduRepository articlevendurepo;
	@Autowired
	CommandeRepository cmdRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	ArticleVenduservImpl artticlevenduserv;
	@Override
	public Commande ajoutercommande(List<Long> articlesv, Commande cmd,Long iduser) {
		cmdRepo.save(cmd);
		User u = userRepo.findById(iduser).orElse(null);
		cmd.setUser(u);
		for(Long a : articlesv) {
			ArticleVendu av=articlevendurepo.findById(a).orElse(null);
			av.getCommande().add(cmd);
			articlevendurepo.save(av);
		}
		return 	cmdRepo.save(cmd);
	}
}



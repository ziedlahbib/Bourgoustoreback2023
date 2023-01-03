package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ArticleRepository;
import tn.esprit.spring.repository.CommandeRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class CommandeServiceImpl implements ICommandeserv{

	@Autowired
	ArticleRepository articleRepo;
	@Autowired
	CommandeRepository cmdRepo;
	@Autowired
	UserRepository userRepo;
	@Override
	public Commande ajouteretAffecterArticle(List<String> idarticles, Commande cmd,Long iduser) {
		User u = userRepo.findById(iduser).orElse(null);/*
		cmdRepo.save(cmd);
		cmd.setUser(u);
		for(String a : idarticles) {
			Article as =articleRepo.findById(a).orElse(null);
			System.out.println("as:"+as.getId());
			as.setCommande(cmd);
			articleRepo.save(as);
		}
		*/
		if(u.getCmd()==null) {
			cmdRepo.save(cmd);
			for(String a : idarticles) {
				Article as =articleRepo.findById(a).orElse(null);
				System.out.println("as:"+as.getId());
				as.getCommande().add(cmd);
				articleRepo.save(as);
			}
			
			cmd.setUser(u);
			return  cmdRepo.save(cmd);
		}else {
			Commande c=u.getCmd();
			for(String a : idarticles) {
				Article as =articleRepo.findById(a).orElse(null);
				System.out.println("as:"+as.getId());
				as.getCommande().add(c);
				articleRepo.save(as);
			}
			return c;
		}
	}

}

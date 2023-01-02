package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Commande;



@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

}

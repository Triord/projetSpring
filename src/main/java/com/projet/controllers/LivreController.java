package com.projet.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Bibliotheque;
import com.projet.beans.Exemplaires;
import com.projet.beans.Livres;
import com.projet.repositories.BookRepository;
import com.projet.repositories.ExemplaireRepo;
import com.projet.repositories.biblioRepo;
import com.projet.services.BookServiceImpl;

@RestController
public class LivreController {

	@Autowired
	private BookRepository bkRep;
	@Autowired
	private BookServiceImpl Livreserv ;

	@GetMapping("/Livres")
	public Set<Livres> allLivre(Model model) {
		return Livreserv.allLivre();
	}

	@GetMapping("/Livres/{id}")
	public Optional<Livres> getBook(@PathVariable int id,Model model) {
		return  Livreserv.infoLivre(id);		
	}
	
	
}

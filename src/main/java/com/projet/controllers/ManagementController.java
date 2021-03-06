
package com.projet.controllers;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Bibliotheque;
import com.projet.beans.Livres;
import com.projet.beans.Locations;
import com.projet.beans.Question;
import com.projet.beans.Redevances;
import com.projet.beans.Reponse;
import com.projet.beans.Roles;
import com.projet.beans.Utilisateurs;
import com.projet.repositories.BookRepository;
import com.projet.repositories.LocRepository;
import com.projet.repositories.RedevanceRepo;
import com.projet.repositories.ReponseRepo;
import com.projet.repositories.RoleRepository;
import com.projet.repositories.UserRepository;
import com.projet.repositories.biblioRepo;
import com.projet.services.BookServiceImpl;
import com.projet.services.LocationServiceImpl;
import com.projet.services.ServiceRequest;
import com.projet.services.UserServiceImpl;
import com.projet.services.biblioService;
import com.projet.services.biblioServiceImpl;
@RestController
public class ManagementController {

	@Autowired
	private BookRepository bkRep;
	@Autowired
	private BookServiceImpl bkS;
	@Autowired
	private LocRepository lkRep;
	
	@RequestMapping(value = "/Livres", method = RequestMethod.POST)
	public ServiceRequest addLivre(@RequestBody Livres livre) {
		return bkS.addBook(livre);
	}
	
	@RequestMapping(value = "/Livres", method = RequestMethod.PUT)
	public Livres upLivre(@RequestBody Livres livre) {
		return bkRep.save(livre);
	}
	@PostMapping("/addbook")
	public Livres addlivre(@RequestBody Livres book) {
		return bkRep.save(book);
	}
	@DeleteMapping("/Livres/{id}")
	public void DelBook(@PathVariable int id) {
	 bkS.DelBook(id);
	}
	@DeleteMapping("/loc/{id}")
	public void DelLoc(@PathVariable int id) {
	 lkRep.deleteById(id);
	}
	
	@Autowired
	private biblioRepo bqRep;
	
	
	@PostMapping("/biblio")
	public Bibliotheque addBiblio(@RequestBody Bibliotheque biblio) {
		return bqRep.save(biblio);
	}
	@Autowired
	private RoleRepository rRep;
	
	// ADD PUT AND DELETE MAPPING 
	@Autowired
	private UserRepository urRep;
	@Autowired
	private UserServiceImpl urS;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/user/{id}")
	public Utilisateurs promUser(@RequestBody Utilisateurs user, @PathVariable int id) {
		return urS.promUser(id, user);
	}
	@PutMapping("/bibliothequaire/{id}")
	public Utilisateurs promBiblio(@RequestBody Utilisateurs user, @PathVariable int id) {
		
		return urS.promBiblio(id, user);
	}
	@PutMapping("/lecteur/{id}")
	public Utilisateurs retroUser(@RequestBody Utilisateurs user, @PathVariable int id) {
		
		return urS.retroUser(id, user);
	}
	@PostMapping("/lecteur")
	public ServiceRequest addUser(@RequestBody Utilisateurs user) {
	
		return urS.addUser(user);
		
	}
	@PostMapping("/bibliothequaire")
	public ServiceRequest addBiblio(@RequestBody Utilisateurs user) {
	
		return urS.addBiblio(user);
		
	}
	@PostMapping("/manaBiblio")
	public ServiceRequest addMana(@RequestBody Utilisateurs user) {
	
		return urS.addMana(user);
		
	}
	
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public void reply(@RequestBody Reponse reponse) {
		urS.reply(reponse);
	}
	
	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public Set<Question> allQ(Model model){
		return urS.allQ();
	}
	@RequestMapping(value = "/payer", method = RequestMethod.POST)
	public void payerR(@RequestBody Redevances r) {
		urS.payeR(r);
	}
	
	
}

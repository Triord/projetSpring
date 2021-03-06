package com.projet.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.beans.Exemplaires;
import com.projet.beans.Livres;
import com.projet.beans.Utilisateurs;
import com.projet.repositories.BookRepository;


@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository livreRep;

	public Set<Livres> allLivre(){
		Set<Livres> l = new HashSet<Livres>((Collection<Livres>) livreRep.findAll());
		return l;
	}
	public Optional<Livres> getId(int id ) {
		Optional<Livres> livre = livreRep.findById(id);
		return livre;
	}
	public Optional<Livres> infoLivre(int id) {
		Optional<Livres> livre = livreRep.findById(id);
		
		return livre;
	}
	public ServiceRequest addBook(Livres book) {
		book = livreRep.save(book);
		if (book != null) {
			return new ServiceRequest(true, "Saved successfully!");
		}
		return new ServiceRequest(false, "Dont saved!");
	}

	public Livres UpdateBooks(int id,Livres livre) {
		
			
		livre.setIdlivre(livre.getIdlivre());
		livre.setNom(livre.getNom());
		livre.setIsbn(livre.getIsbn());
		livre.setDescriptif(livre.getDescriptif());
		livre.setEdition(livre.getEdition());
		livre.setPrix(livre.getPrix());
		livre.setEtat(true);
		livre.setEx(livre.getEx());
		livre = livreRep.save(livre);
		return livre;
	}
	public void DelBook(int id) {
		
		livreRep.deleteById(id);
	}

}

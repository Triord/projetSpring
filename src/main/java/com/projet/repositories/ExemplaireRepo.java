package com.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.projet.beans.Exemplaires;

import java.util.*;

@Repository
public interface ExemplaireRepo extends JpaRepository<Exemplaires, Integer> {
	@Query(value ="select count(*) from exemplaires e join livre l on e.idLivre = l.idLivre where l.idLivre =:id ", nativeQuery =true)
	int findqqt(int id);
}

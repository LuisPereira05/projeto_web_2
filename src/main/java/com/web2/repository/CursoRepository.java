package com.web2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web2.model.Curso;
import com.web2.model.Categoria;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
	List<Curso> findCursoByNomeLike(String nome);
	List<Curso> findAll();
	Optional<Curso> findById(Long id);
	List<Curso> findByCategoriaId(Long id);
}

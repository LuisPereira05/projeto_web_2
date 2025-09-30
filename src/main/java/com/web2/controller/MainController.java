package com.web2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web2.model.Categoria;
import com.web2.model.Curso;
import com.web2.repository.CategoriaRepository;
import com.web2.repository.CursoRepository;
import com.web2.repository.ProfessorRepository;

@Controller
@RequestMapping("")
public class MainController {
    @Autowired
    CategoriaRepository catRepository;

    @Autowired
    ProfessorRepository profRepository;

    @Autowired
    CursoRepository curRepository;

    @GetMapping("/home")
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView("index");
		List<Categoria> lista = catRepository.findAll();
        List<Curso> cursos = curRepository.findAll();
		mv.addObject("categorias", lista);
        mv.addObject("cursos", cursos);
		return mv;
	}

    @GetMapping("/home/buscar")
    public ModelAndView buscarCursos(@RequestParam("termo") String termo) {
        ModelAndView mv = new ModelAndView("index");
        List<Curso> resCursos = curRepository.findCursoByNomeLike("%" + termo + "%");
        List<Categoria> lista = catRepository.findAll();
        mv.addObject("categorias", lista);
        mv.addObject("cursos", resCursos);
        mv.addObject("isSearch", true);
        return mv;
    }

}

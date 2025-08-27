package br.com.alunocrud.springboot_student_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alunocrud.springboot_student_crud.model.Aluno;
import br.com.alunocrud.springboot_student_crud.service.AlunoService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/products")
public class AlunoController {
    
    @Autowired
    AlunoService alunoService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("alunos", alunoService.listAll());
        return "list";
    }

    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("aluno", new Aluno());
        return "form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model, RedirectAttributes attributes){
        try {
            model.addAttribute("aluno", alunoService.findAluno(id));
            return "form";
        } catch (RuntimeException e) {
            attributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/products";
        }
    }

    @PostMapping
    public String save(@Valid Aluno aluno,
            BindingResult result,
            RedirectAttributes attributes) {
        if(result.hasErrors())
            return "form";
        alunoService.createAluno(aluno);
        attributes.addFlashAttribute("message", "Aluno salvo com sucesso!");
        return "redirect:/alunos"; 
    }
    

}

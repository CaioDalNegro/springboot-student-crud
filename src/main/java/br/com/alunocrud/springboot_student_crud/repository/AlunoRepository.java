package br.com.alunocrud.springboot_student_crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alunocrud.springboot_student_crud.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
        List<Aluno>findByNameContainingIgnoreCase(String name);
}

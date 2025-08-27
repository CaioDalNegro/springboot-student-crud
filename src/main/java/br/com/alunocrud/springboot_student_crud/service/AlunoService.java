package br.com.alunocrud.springboot_student_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alunocrud.springboot_student_crud.model.Aluno;
import br.com.alunocrud.springboot_student_crud.repository.AlunoRepository;

@Service
public class AlunoService {
    
    @Autowired
    AlunoRepository alunoRepository;

    // Listar todos os alunos
    public List<Aluno> listAll(){
        return alunoRepository.findAll();
    }

    // Buscar aluno por id
    public Aluno findAluno(Long id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isPresent()){
            return aluno.get();
        }
        throw new RuntimeException("Aluno não encontrado!");
    }

    // Cadastrar ou autualizar aluno
    public Aluno createAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    // Remover aluno
    public void deleteAluno(Long id){
        if (!alunoRepository.existsById(id))
            throw new RuntimeException("Erro ao excluir produto!");
        alunoRepository.deleteById(id);
    }
}

package br.com.alunocrud.springboot_student_crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Aluno {
    
    // Atributos---------------->
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome nao pode estar em branco!")
    private String name;

    @NotNull(message = "A idade é obrigatória")
    @Positive(message = "A idade tem que ser um numero positivo!")
    private int idade;

    // Construtores ------------>
    public Aluno() {}

    public Aluno(Long id, @NotBlank(message = "O nome nao pode estar em branco!") String name,
            @NotNull(message = "A idade é obrigatória") @Positive(message = "A idade tem que ser um numero positivo!") int idade) {
        this.id = id;
        this.name = name;
        this.idade = idade;
    }

    // Getter e setter---------->
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    } 
}

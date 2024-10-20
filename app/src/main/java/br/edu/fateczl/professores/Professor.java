package br.edu.fateczl.professores;

public abstract class Professor{
    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    private String nome;
    private String matricula;
    private int idade;

    public Professor(String nome, String matricula, int idade){
        setNome(nome);
        setMatricula(matricula);
        setIdade(idade);
    }

    public abstract double calcSalario();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}

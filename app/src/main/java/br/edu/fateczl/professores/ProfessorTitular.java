package br.edu.fateczl.professores;

public class ProfessorTitular extends Professor {
    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    private int anosInstituicao;
    private double salario;

    public ProfessorTitular(int anosInstituicao, double salario, String nome, String matricula, int idade) {
        super(nome, matricula, idade);
        setAnosInstituicao(anosInstituicao);
        setSalario(salario);
    }

    @Override
    public double calcSalario() {
        double incremento = 1 + (0.05d * (int)(this.anosInstituicao / 5));
        return incremento * this.salario;
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

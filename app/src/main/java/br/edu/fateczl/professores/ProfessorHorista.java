package br.edu.fateczl.professores;

public class ProfessorHorista extends Professor{
    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    private int horasAula;
    private double valorHoraAula;

    public ProfessorHorista(int horasAula, double valorHoraAula, String nome, String matricula, int idade) {
        super(nome, matricula, idade);
        setHorasAula(horasAula);
        setValorHoraAula(valorHoraAula);
    }

    @Override
    public double calcSalario() {
        return this.horasAula * this.valorHoraAula;
    }

    public int getHorasAula() {
        return horasAula;
    }

    public void setHorasAula(int horasAula) {
        this.horasAula = horasAula;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }
}

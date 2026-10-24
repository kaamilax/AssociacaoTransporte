package domain;

import Parameters.Turno;

import java.util.ArrayList;

public class Motorista {
    private String CPF;
    private String nome;
    private String CNH;
    private String telefone;
    private ArrayList<Viagem> viagens;

    public Motorista(String CPF, String nome, String CNH, String telefone) {
        this.CPF = CPF;
        this.nome = nome;
        this.CNH = CNH;
        this.telefone = telefone;
        this.viagens = new ArrayList<>();
    }

    public void addViagem(Viagem viagem){
        if(viagem == null) throw new IllegalArgumentException("Viagem n pode ser vazia.");

        viagens.add(viagem);
    }

    public void removerViagem(Viagem viagem){
        viagens.remove(viagem);
    }

    public int qtdViagens(){
        return viagens.size();
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCNH(String CNH) {
        this.CNH = CNH;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setViagens(ArrayList<Viagem> viagens) {


        this.viagens = viagens;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getCNH() {
        return CNH;
    }

    public String getTelefone() {
        return telefone;
    }

    public ArrayList<Viagem> getViagens() {
        return viagens;
    }
}

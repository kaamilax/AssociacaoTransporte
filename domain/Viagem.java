package domain;

import Parameters.SituacaoViagem;
import Parameters.Turno;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Viagem {
    private LocalDateTime data;
    private Turno turno;
    private Veiculo veiculo;
    private Motorista motorista;
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private SituacaoViagem situacaoViagem;
    private Rota rota;

    public Viagem(LocalDateTime data, Turno turno, Veiculo veiculo, Motorista motorista, Rota rota) {
        this.data = data;
        this.turno = turno;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.alunos = new ArrayList<>();
        this.rota = rota;
    }

    public void addAluno(Aluno aluno){
        if(aluno == null){
            throw new IllegalArgumentException("Aluno não pode ser vazio.");
        }

        if(aluno.verificarInadimplencia()){
            throw new IllegalArgumentException("Aluno não pode ser inadimplente para viajar: " + aluno.getNome());
        }

        if(alunos.contains(aluno)){
            throw new IllegalArgumentException("Aluno já cadastrado: " + aluno.getNome());
        }

        int capacidade = veiculo.getCapacidadePorVeiculo();

        if(alunos.size() >= capacidade) throw new IllegalArgumentException("Capacidade máxima atingida.");

        alunos.add(aluno);

    }

    public void removerAluno(Aluno aluno){
        alunos.remove(aluno);
    }

    public double clacularCusto(){
        return rota.custoViagem(veiculo.getTipoVeiculo());
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void setSituacaoViagem(SituacaoViagem situacaoViagem) {
        this.situacaoViagem = situacaoViagem;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Turno getTurno() {
        return turno;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public SituacaoViagem getSituacaoViagem() {
        return situacaoViagem;
    }

    public Rota getRota() {
        return rota;
    }
}


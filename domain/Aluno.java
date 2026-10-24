package domain;

import Parameters.Instituicao;
import Parameters.SituacaoPagamento;
import Parameters.Turno;

import java.util.ArrayList;

public class Aluno {
    private String matricula;
    private String nome;
    private Rota rota;
    private Turno turnoIda, turnoVolta;
    private ArrayList<Pagamento> pagamentos = new ArrayList<>();
    private Instituicao instituicao;


    public Aluno(String matricula, String nome, Rota rota, Turno turnoIda, Turno turnoVolta, Instituicao instituicao) {
        this.matricula = matricula;
        this.nome = nome;
        this.rota = rota;
        this.turnoIda = turnoIda;
        this.turnoVolta = turnoVolta;
        this.instituicao = instituicao;

    }

    public void addPagamento(Pagamento pagamento){
        pagamentos.add(pagamento);
    }

    public int contPagamentosAtrasados(){
        int contAtrasados = 0;
        for (Pagamento pagamento : pagamentos){
            if(pagamento.verificarAtraso()) contAtrasados++;
        }

        return contAtrasados;

    }

    public boolean verificarInadimplencia(){
       return contPagamentosAtrasados() >= 3;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        if(nome.isEmpty() || nome == null){
            throw new IllegalArgumentException("Nome não deve ser vazio.");
        }

        this.nome = nome;
    }



    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public void setTurnoIda(Turno turnoIda) {
        this.turnoIda = turnoIda;
    }

    public void setTurnoVolta(Turno turnoVolta) {
        this.turnoVolta = turnoVolta;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public Rota getRota() {
        return rota;
    }

    public Turno getTurnoIda() {
        return turnoIda;
    }

    public Turno getTurnoVolta() {
        return turnoVolta;
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }
}

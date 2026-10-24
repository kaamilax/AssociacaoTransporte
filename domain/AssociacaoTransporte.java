package domain;

import Parameters.Instituicao;

import java.util.ArrayList;

public class AssociacaoTransporte {
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Motorista> motoristas = new ArrayList<>();
    private ArrayList<Veiculo> veiculos= new ArrayList<>();
    private ArrayList<Rota> rotas = new ArrayList<>();
    private ArrayList<Instituicao> instituicoes = new ArrayList<>();
    private ArrayList<Pagamento> pagamentos = new ArrayList<>();
    private ArrayList<Viagem> viagens = new ArrayList<>();


    public double calcularReceita(){
        double receitaF = 0;

        for(Aluno aluno : alunos){
            if(!aluno.verificarInadimplencia()) receitaF += aluno.getRota().custoMensal();
        }

        return receitaF;

    }

    public double calcularCustoP(){
        double custoT = 0;

        for (Viagem viagem : viagens){
            custoT += viagem.clacularCusto();
        }

        return custoT;
    }

    public double calcularLucroAssociacao(){
        return calcularReceita() - calcularCustoP();
    }


    public void addAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public void addMotorista(Motorista motorista){
        motoristas.add(motorista);
    }

    public void addVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }

    public void addRota(Rota rota){
        rotas.add(rota);
    }

    public void addInstituicao(Instituicao instituicao){
        instituicoes.add(instituicao);
    }

    public void addPagamento(Pagamento pagamento){
        pagamentos.add(pagamento);
    }

    public void addViagem(Viagem viagem){
        viagens.add(viagem);
    }


    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public ArrayList<Motorista> getMotoristas() {
        return motoristas;
    }

    public ArrayList<Rota> getRotas() {
        return rotas;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public ArrayList<Viagem> getViagens() {
        return viagens;
    }

    public ArrayList<Instituicao> getInstituicoes() {
        return instituicoes;
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }
}

package Services;

import Parameters.Instituicao;
import Parameters.SituacaoVeiculo;
import domain.*;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class RelatorioService {
    private final AssociacaoTransporte associacaoTransporte;

    public RelatorioService(AssociacaoTransporte associacaoTransporte){
        if(associacaoTransporte == null) throw new IllegalArgumentException("Assiacao n pode ser nula.");

        this.associacaoTransporte = associacaoTransporte;
    }

    public ArrayList<String> qtdAlunosRota(){
        ArrayList<String> result = new ArrayList<>();

        for (Rota rota : associacaoTransporte.getRotas()){
            int qtd=0;

            for (Aluno aluno : associacaoTransporte.getAlunos()){
                if(aluno.getRota() == rota) qtd++;
            }

            result.add(rota.getMunicipioDestino() + ": " + qtd + " alunos");

        }

        return result;

    }

    public  ArrayList<String> qtdAlunoInst(){
        ArrayList<String> result = new ArrayList<>();

        for (Instituicao instituicao : associacaoTransporte.getInstituicoes()){
            int qtd = 0;

            for (Aluno aluno : associacaoTransporte.getAlunos()){
                if(aluno.getInstituicao() == instituicao) qtd++;
            }

            result.add(instituicao + ": " + qtd + " alunos");

        }

        return result;

    }

    public int qtdAlunosInadimplentes(){
        int qtd=0;

        for (Aluno aluno : associacaoTransporte.getAlunos()){
            if(aluno.verificarInadimplencia()) qtd++;
        }

        return qtd;

    }

    public ArrayList<Veiculo> veiculosDosponiveis(){
        ArrayList<Veiculo> result = new ArrayList<>();

        for(Veiculo veiculo : associacaoTransporte.getVeiculos()){
            if(veiculo.getSituacaoVeiculo() == SituacaoVeiculo.DISPONIVEL) result.add(veiculo);
        }

        return result;
    }

    public ArrayList<String> vagasDisponiveisViagem(){
        ArrayList<String> result = new ArrayList<>();

        for (Viagem viagem : associacaoTransporte.getViagens()){
            int cpc = viagem.getVeiculo().getCapacidadePorVeiculo();
            int ocupadas = viagem.getAlunos().size();
            int vagas = cpc - ocupadas;

            result.add(viagem.getData() + ": " + viagem.getTurno() + ": " + viagem.getRota().getMunicipioDestino() + ": Vagas disponiveis = " + vagas);

        }

        return result;
    }

    public double calcCustoEstimado(){
        double tot=0;

        for (Viagem viagem : associacaoTransporte.getViagens()){
            tot += viagem.clacularCusto();
        }

        return tot;

    }

    public double calcReceitaMensal(){
        double tot=0;

        for (Aluno aluno : associacaoTransporte.getAlunos()){
            if(!aluno.verificarInadimplencia()){
                tot += aluno.getRota().custoMensal();
            }
        }

        return tot;

    }

    public void imprimirRelatorio(){
        System.out.println("----------------------------------------------");
        System.out.println("               RELATORIO FINAL                ");
        System.out.println("----------------------------------------------");

        System.out.println("ALUNOS POR ROTA");
        for (String i : qtdAlunosRota()){
            System.out.println(i);
        }

        System.out.println();
        System.out.println("ALUNOS POR INSTITUICAO");
        for (String i : qtdAlunoInst()){
            System.out.println(i);
        }

        System.out.println();
        System.out.println("QUANTIDADE DE ALUNOS INADIMPLENTES");
        System.out.println(qtdAlunosInadimplentes());

        System.out.println();
        System.out.println("VEICULOS DISPONIVEIS");
        for (Veiculo v : veiculosDosponiveis()){
            System.out.println("IDENTIFICACAO");
            System.out.println(v.getIdentificacaoInterna());
            System.out.println("PLACA");
            System.out.println(v.gerarPlacaVeiculo());
        }

        System.out.println();
        System.out.println("VAGAS DISP. POR VIAGEM");
        for(String i : vagasDisponiveisViagem()){
            System.out.println(i);
        }

        System.out.println();
        System.out.println("VIAGENS PROGRAMADAS");
        for (Viagem viagem : associacaoTransporte.getViagens()){
            System.out.println(viagem.getData() + " : " + viagem.getTurno() + " : " + viagem.getRota().getMunicipioDestino());
        }

        System.out.println();
        System.out.printf("%nCUSTO ESTIMADO: R$ %.2f%n", calcCustoEstimado());

        System.out.println();
        System.out.printf("RECEITA MENSAL: R$ %.2f%n", calcReceitaMensal());

    }

}

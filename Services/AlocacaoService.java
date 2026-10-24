package Services;

import Parameters.SituacaoVeiculo;
import Parameters.Turno;
import domain.Aluno;
import domain.AssociacaoTransporte;
import domain.Rota;
import domain.Veiculo;

import java.util.ArrayList;

public class AlocacaoService {
    private AssociacaoTransporte associacaoTransporte;

    public AlocacaoService(AssociacaoTransporte associacaoTransporte) {
        this.associacaoTransporte = associacaoTransporte;
    }

    public ArrayList<Aluno> getAlunosCadastrados(Rota rota, Turno turno){
        ArrayList<Aluno> alunosRT = new ArrayList<>();

        for (Aluno aluno : associacaoTransporte.getAlunos()){
            if(!aluno.verificarInadimplencia() && aluno.getRota() == rota && (aluno.getTurnoIda() == turno || aluno.getTurnoVolta() == turno)){
                alunosRT.add(aluno);
            }
        }

        return alunosRT;

    }

    public ArrayList<ArrayList<Aluno>> distribuirAlunos(ArrayList<Aluno> alunos, ArrayList<Veiculo> veiculos){

        ArrayList<ArrayList<Aluno>> gruposAlunos = new ArrayList<>();

        int iAluno = 0;
        int iVeiculo = 0;

        while (iAluno < alunos.size() && iVeiculo < veiculos.size()){
            Veiculo veiculo = veiculos.get(iVeiculo);

            if(veiculo.getSituacaoVeiculo() != SituacaoVeiculo.DISPONIVEL){
                iVeiculo++;
                continue;
            }

            ArrayList<Aluno> grupo = new ArrayList<>();
            int capacidade = veiculo.getCapacidadePorVeiculo();

            while (iAluno < alunos.size() && grupo.size() < capacidade){
                grupo.add(alunos.get(iAluno));
                iAluno++;
            }

            gruposAlunos.add(grupo);
            iVeiculo++;

        }

        return gruposAlunos;

    }






}

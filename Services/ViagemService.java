package Services;

import Parameters.SituacaoVeiculo;
import Parameters.Turno;
import domain.Aluno;
import domain.AssociacaoTransporte;
import domain.Viagem;

import java.util.ArrayList;

public class ViagemService {
    private AssociacaoTransporte associacaoTransporte;

    public ViagemService(AssociacaoTransporte associacaoTransporte){
        this.associacaoTransporte = associacaoTransporte;
    }

    public void addViagem(Viagem nViagem){
        if(nViagem == null) throw new IllegalArgumentException("Viagem não pode ser nula.");

        for (Viagem viagem : associacaoTransporte.getViagens()){
            if(!(viagem.getData().toLocalDate().equals(nViagem.getData().toLocalDate()))) continue;

            if(viagem.getTurno() == nViagem.getTurno() && viagem.getMotorista() == nViagem.getMotorista()) throw new IllegalArgumentException("Motorista já possui uma viagem neste turno.");

            if(viagem.getMotorista() == nViagem.getMotorista() && ((viagem.getTurno() == Turno.MANHA && nViagem.getTurno() == Turno.NOITE) || (viagem.getTurno() == Turno.NOITE && nViagem.getTurno() == Turno.MANHA))) throw new IllegalArgumentException("Motorista não pode trabalhar de manha e à noite no mesmo dia.");

            if(viagem.getVeiculo() == nViagem.getVeiculo() && viagem.getTurno() == nViagem.getTurno()) throw new IllegalArgumentException("Veiculo ocupado neste turno.");
        }

        associacaoTransporte.addViagem(nViagem);
        nViagem.getMotorista().addViagem(nViagem);

    }

    public void vRetorno(Aluno aluno){
        if(aluno == null)  throw new IllegalArgumentException("Aluno não pode ser nulo.");

        for (Viagem viagem : associacaoTransporte.getViagens()){

            if(viagem.getAlunos().contains(aluno) && viagem.getTurno() == aluno.getTurnoVolta()) return;
        }

        throw new IllegalArgumentException("Aluno " + aluno.getNome() + " não possui viagem no turno de volta.");

    }

    public void mudarturno(Viagem viagem, Turno nTurno){
        if(viagem == null) throw new IllegalArgumentException("Viagem não pode ser nula.");

        if(nTurno == null) throw new IllegalArgumentException("turno não pode ser nulo.");

        for (Viagem e : associacaoTransporte.getViagens()){
            if(e == viagem) continue;

            if(viagem.getVeiculo().getSituacaoVeiculo() == SituacaoVeiculo.INDISPONIVEL) throw new IllegalArgumentException("Não é possível mudar de turno pois não há vagas disponiveis.");

            if(!e.getData().toLocalDate().equals(viagem.getData().toLocalDate())) continue;

            if(e.getData().toLocalDate().equals(viagem.getData().toLocalDate()) && e.getTurno() == nTurno){
                if(e.getMotorista() == viagem.getMotorista()) throw new IllegalArgumentException("Motorista indisponível neste turno.");

                if(e.getVeiculo() == viagem.getVeiculo()) throw new IllegalArgumentException("Veiculo ocupado para este turno.");
            }

            if(e.getMotorista() == viagem.getMotorista() && ((e.getTurno() == Turno.MANHA && nTurno == Turno.NOITE) || (e.getTurno() == Turno.NOITE && nTurno == Turno.MANHA))){
                throw new IllegalArgumentException("Motorista n pode trabalhar de manha e à noite no mesmo turno.");
            };

        }

        viagem.setTurno(nTurno);

    }

    public ArrayList<Viagem> Listviagens(){
        return associacaoTransporte.getViagens();
    }

    public ArrayList<Viagem> getViagensByTurno(Turno turno){
        ArrayList<Viagem> result = new ArrayList<>();

        for(Viagem viagem : associacaoTransporte.getViagens()){
            if(viagem.getTurno() == turno){
                result.add(viagem);
            }
        }

        return result;

    }





}

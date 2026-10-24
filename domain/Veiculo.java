package domain;

import Parameters.SituacaoVeiculo;
import Parameters.TipoVeiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Veiculo {
    private Motorista motorista;
    private String identificacaoInterna;
    private SituacaoVeiculo situacaoVeiculo;
    private TipoVeiculo tipoVeiculo;
    private String placa;

    public Veiculo(TipoVeiculo tipoVeiculo, Motorista motorista, String identificacaoInterna, SituacaoVeiculo situacaoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
        this.motorista = motorista;
        this.identificacaoInterna = identificacaoInterna;
        this.situacaoVeiculo = situacaoVeiculo;
        this.gerarPlacaVeiculo();
    }

    public String gerarPlacaVeiculo(){
        placa = "";
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < 3; i++) {
            int pos = ThreadLocalRandom.current().nextInt(letras.length());
            placa += letras.charAt(pos);

        }

        placa += "-";

        for (int i = 0; i < 3; i++) {
            int num = ThreadLocalRandom.current().nextInt(10);
            placa += num;
        }

        return placa;

    }

    public int getCapacidadePorVeiculo(){
        if(tipoVeiculo == TipoVeiculo.ONIBUS) return 40;

        if(tipoVeiculo == TipoVeiculo.VAN) return 20;

        return 0;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public void setIdentificacaoInterna(String identificacaoInterna) {
        this.identificacaoInterna = identificacaoInterna;
    }

    public void setSituacaoVeiculo(SituacaoVeiculo situacaoVeiculo) {
        this.situacaoVeiculo = situacaoVeiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getIdentificacaoInterna() {
        return identificacaoInterna;
    }

    public SituacaoVeiculo getSituacaoVeiculo() {
        return situacaoVeiculo;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getPlaca() {
        return placa;
    }
}

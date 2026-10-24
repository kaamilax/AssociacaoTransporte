package domain;

import Parameters.Municipio;
import Parameters.TipoVeiculo;

public class Rota {
    private Municipio municipioDestino;
    private double distancia;

    public Rota(Municipio municipioDestino, double distancia) {
        this.municipioDestino = municipioDestino;
        this.distancia = distancia;
    }

    public double custoMensal(){
        if(municipioDestino == Municipio.LAGARTO) return 600.00;

        if(municipioDestino == Municipio.PARIPIRANGA) return 700.00;

        if(municipioDestino == Municipio.ARACAJU) return 900.00;

        return 0;

    }

    public double custoViagem(TipoVeiculo tipoVeiculo){
        if(tipoVeiculo == TipoVeiculo.VAN) return distancia * 2.0;

        if(tipoVeiculo == TipoVeiculo.ONIBUS) return distancia * 5.0;

        return 0;
    }

    public Municipio getMunicipioDestino() {
        return municipioDestino;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setMunicipioDestino(Municipio municipioDestino) {
        this.municipioDestino = municipioDestino;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

}

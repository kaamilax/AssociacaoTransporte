package domain;

import Parameters.SituacaoPagamento;

import java.time.LocalDateTime;

public class Pagamento {

    private Aluno aluno;
    private Double valorPagar;
    private LocalDateTime dataVencimento;
    private LocalDateTime dataPagamento = null;
    private SituacaoPagamento situacaoPagamento = SituacaoPagamento.PENDENTE;

    public Pagamento(Aluno aluno, Double valorPagar, LocalDateTime dataVencimento) {
        this.aluno = aluno;
        this.valorPagar = valorPagar;
        this.dataVencimento = dataVencimento;
    }

    public void registrarPagamento(){
        dataPagamento = LocalDateTime.now();
        situacaoPagamento = SituacaoPagamento.PAGO;
    }

    public boolean verificarPagamento(){
        if(situacaoPagamento == SituacaoPagamento.PENDENTE){
            return false;
        }

        return true;
    }

    public boolean verificarAtraso(){
        return situacaoPagamento == SituacaoPagamento.PENDENTE && LocalDateTime.now().isAfter(dataVencimento);

    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setValorPagar(Double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public void setDataVencimento(LocalDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Double getValorPagar() {
        return valorPagar;
    }

    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public SituacaoPagamento getSituacaoPagamento() {
        return situacaoPagamento;
    }
}

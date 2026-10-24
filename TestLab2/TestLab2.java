
package TestLab2;


import Parameters.*;
import Services.RelatorioService;
import Services.ViagemService;
import domain.*;

import java.time.LocalDateTime;

public class TestLab2 {
    static void main(String[] args) {

        AssociacaoTransporte associacaoTransporte = new AssociacaoTransporte();

        Rota rtLag = new Rota(Municipio.LAGARTO, 40);
        Rota rtAju = new Rota(Municipio.ARACAJU, 120);
        Rota rtPar = new Rota(Municipio.PARIPIRANGA, 60);

        associacaoTransporte.addRota(rtLag);
        associacaoTransporte.addRota(rtAju);
        associacaoTransporte.addRota(rtPar);

        associacaoTransporte.addInstituicao(Instituicao.AGES);
        associacaoTransporte.addInstituicao(Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);
        associacaoTransporte.addInstituicao(Instituicao.UNIT);
        associacaoTransporte.addInstituicao(Instituicao.PIO_X);

        Aluno a1 = new Aluno("48485858", "Simone Morena", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a2 = new Aluno("8948469", "Raquel dos teclados", rtAju, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a3 = new Aluno("599595", "JOJO", rtAju, Turno.TARDE, Turno.NOITE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a4 = new Aluno("94949494", "Peter Steele", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a5 = new Aluno("16546484", "ana", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a6 = new Aluno("78855444", "paula", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a7 = new Aluno("10101010", "Naruto", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a8 = new Aluno("55858888", "Sasuke", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a9 = new Aluno("14788997", "Ash", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a10 = new Aluno("1212121", "Eiji", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a11 = new Aluno("36363636", "Peter Park", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a12 = new Aluno("20202020", "Dean", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a13 = new Aluno("77777888", "Sam", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a14 = new Aluno("45545454", "Ben", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a15 = new Aluno("9448544", "Castiel", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a16 = new Aluno("0088877", "Tom", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a17 = new Aluno("8989898", "Bobby", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.UNIT);

        Aluno a18 = new Aluno("5656565", "Rick", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.PIO_X);

        Aluno a19 = new Aluno("85858888", "Juddity", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.PIO_X);

        Aluno a20 = new Aluno("02222217", "Rosita", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.UNIT);

        Aluno a21 = new Aluno("13131313", "Michone", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a22 = new Aluno("89898989", "Glen", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a23 = new Aluno("14141414", "John", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a24 = new Aluno("63666336", "Cloe", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a25 = new Aluno("7474747", "Sammy", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a26 = new Aluno("11111111", "Sakura", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a27 = new Aluno("33333333", "Goku", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a28 = new Aluno("88888888", "Boruto", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a29 = new Aluno("7777774", "Hinata", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a30 = new Aluno("3366666", "Midori", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.UNIT);

        Aluno a31 = new Aluno("54447878", "Gojo", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a32 = new Aluno("6969522", "Tanjiro", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.AGES);

        Aluno a33 = new Aluno("56565477", "Zenitsu", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a34 = new Aluno("47475522", "Takemichi", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.UNIT);

        Aluno a35 = new Aluno("000112223", "Sarada", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.PIO_X);

        Aluno a36 = new Aluno("13131020", "Garaa", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.UNIT);

        Aluno a37 = new Aluno("555555444", "Megam", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.PIO_X);

        Aluno a38 = new Aluno("78854414", "Dani", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a39 = new Aluno("34516985", "Mike", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.PIO_X);

        Aluno a40 = new Aluno("45445433", "Punpun", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        Aluno a41 = new Aluno("98989999", "Lan zhan", rtLag, Turno.MANHA, Turno.TARDE, Instituicao.INSTITUTO_FEDERAL_DE_SERGIPE_LAGARTO);

        associacaoTransporte.addAluno(a1);
        associacaoTransporte.addAluno(a2);
        associacaoTransporte.addAluno(a3);
        associacaoTransporte.addAluno(a4);

        associacaoTransporte.addAluno(a5);
        associacaoTransporte.addAluno(a6);
        associacaoTransporte.addAluno(a7);
        associacaoTransporte.addAluno(a8);

        associacaoTransporte.addAluno(a9);
        associacaoTransporte.addAluno(a10);
        associacaoTransporte.addAluno(a11);
        associacaoTransporte.addAluno(a12);

        associacaoTransporte.addAluno(a13);
        associacaoTransporte.addAluno(a14);
        associacaoTransporte.addAluno(a15);
        associacaoTransporte.addAluno(a16);

        associacaoTransporte.addAluno(a17);
        associacaoTransporte.addAluno(a18);
        associacaoTransporte.addAluno(a19);
        associacaoTransporte.addAluno(a20);

        associacaoTransporte.addAluno(a21);
        associacaoTransporte.addAluno(a22);
        associacaoTransporte.addAluno(a23);
        associacaoTransporte.addAluno(a24);

        associacaoTransporte.addAluno(a25);
        associacaoTransporte.addAluno(a26);
        associacaoTransporte.addAluno(a27);
        associacaoTransporte.addAluno(a28);

        associacaoTransporte.addAluno(a29);
        associacaoTransporte.addAluno(a30);
        associacaoTransporte.addAluno(a31);
        associacaoTransporte.addAluno(a32);

        associacaoTransporte.addAluno(a33);
        associacaoTransporte.addAluno(a34);
        associacaoTransporte.addAluno(a35);
        associacaoTransporte.addAluno(a36);

        associacaoTransporte.addAluno(a37);
        associacaoTransporte.addAluno(a38);
        associacaoTransporte.addAluno(a39);
        associacaoTransporte.addAluno(a40);
        associacaoTransporte.addAluno(a41);


        Motorista mt1 = new Motorista("111111111113", "Jiraya Sensei", "95959595", "1199993939");

        Motorista mt2 = new Motorista("133333333333", "Kakashi SEM pai", "4949949", "1193993939");

        Motorista mt3 = new Motorista("144444444444", "Tanjiro", "45454545", "78444885541");

        associacaoTransporte.addMotorista(mt1);
        associacaoTransporte.addMotorista(mt2);
        associacaoTransporte.addMotorista(mt3);

        Veiculo v1 = new Veiculo(TipoVeiculo.ONIBUS, mt1, "BUS-013", SituacaoVeiculo.DISPONIVEL);

        Veiculo v2 = new Veiculo(TipoVeiculo.VAN, mt2, "VAN-013", SituacaoVeiculo.DISPONIVEL);

        Veiculo v3 = new Veiculo(TipoVeiculo.ONIBUS, mt3, "VAN-013", SituacaoVeiculo.DISPONIVEL);

        associacaoTransporte.addVeiculo(v1);
        associacaoTransporte.addVeiculo(v2);
        associacaoTransporte.addVeiculo(v3);

        LocalDateTime date = LocalDateTime.of(2026, 11, 13, 13, 13);

        Viagem viagem1 = new Viagem(date, Turno.MANHA, v1, mt1, rtLag);
        Viagem viagem2 = new Viagem(date.withHour(10), Turno.MANHA, v2, mt2, rtAju);
        Viagem viagem3 = new Viagem(date, Turno.NOITE, v3, mt3, rtPar);

        viagem1.addAluno(a1);
        viagem1.addAluno(a2);
        viagem3.addAluno(a3);
        viagem1.addAluno(a4);
        viagem1.addAluno(a5);
        
        viagem1.addAluno(a6);
        viagem1.addAluno(a7);
        viagem1.addAluno(a8);
        viagem1.addAluno(a9);
        viagem1.addAluno(a10);

        viagem1.addAluno(a11);
        viagem1.addAluno(a12);
        viagem1.addAluno(a13);
        viagem1.addAluno(a14);
        viagem1.addAluno(a15);

        viagem1.addAluno(a16);
        viagem1.addAluno(a17);
        viagem1.addAluno(a18);
        viagem1.addAluno(a19);
        viagem1.addAluno(a20);

        viagem2.addAluno(a21);
        viagem2.addAluno(a22);
        viagem2.addAluno(a23);
        viagem2.addAluno(a24);
        viagem2.addAluno(a25);
        viagem2.addAluno(a26);

        viagem2.addAluno(a27);
        viagem2.addAluno(a28);
        viagem2.addAluno(a29);
        viagem2.addAluno(a30);
        viagem2.addAluno(a31);
        viagem2.addAluno(a32);

        viagem2.addAluno(a33);
        viagem2.addAluno(a34);
        viagem2.addAluno(a35);
        viagem2.addAluno(a36);
        viagem2.addAluno(a37);
        viagem2.addAluno(a38);
        viagem2.addAluno(a39);
        //viagem2.addAluno(a40);
        //viagem2.addAluno(a41);

        ViagemService viagemService = new ViagemService(associacaoTransporte);

        viagemService.addViagem(viagem1);
        viagemService.addViagem(viagem2);
        viagemService.addViagem(viagem3);


        RelatorioService relatorioService = new RelatorioService(associacaoTransporte);

        relatorioService.imprimirRelatorio();



    }

}

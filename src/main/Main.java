package main;

import entities.BCP;
import filas.*;
import logging.Logging;

public class Main {
    public static void main(String[] args) {

        int total_quantum = 0;
        int instrucoes = 0;
        int quantidade_processos;
        float  media_trocas, media_quantums;
        // Criacao das estruturas
        int n_com, X, Y;



        FilaBloqueados filaBloqueados = new FilaBloqueados();
        FilaProntos filaProntos = new FilaProntos();
        TabelaDeProcessos tabelaDeProcessos = new TabelaDeProcessos();
        FileHandler filehandler = new FileHandler(tabelaDeProcessos);
        FilaHandler filaHandler = new FilaHandler(filaProntos, filaBloqueados, tabelaDeProcessos);

        filehandler.processar();
        filaHandler.inicializaFilaProntos();

        Logging.startLog(tabelaDeProcessos.getQuantum());

        filaProntos.logFilaProntos();

        quantidade_processos = filaProntos.getSize();

        // Imprime os processos adicionados (teste)
        //tabelaDeProcessos.print();

        // Laco principal
        while(tabelaDeProcessos.exists()){
            if(filaProntos.isEmpty()) {
                filaHandler.atualizarBloqueados();
                continue;
            }
            if(filaProntos.valorCreditoMaximo() == 0 && filaBloqueados.isEmpty()){
                tabelaDeProcessos.resetarCreditos();
            }
            BCP bcp = filaProntos.getNext();
            bcp.setEstado(Estados.EXECUTANDO);

            Logging.log("Executando " + bcp.getProgramName());

            if(bcp.getCreditos() != 0) bcp.useCredito();

            X = bcp.getX();
            Y = bcp.getY();
            filaHandler.atualizarBloqueados();


            for(n_com = 0; n_com < tabelaDeProcessos.getQuantum(); n_com++){
                if(bcp.getEstado() != Estados.EXECUTANDO) break;
                String command = bcp.getNextCommand();
                switch(command.charAt(0)){
                    case 'E':
                        bcp.setEstado(Estados.BLOQUEADO);
                        filaBloqueados.adicionarBloqueado(bcp);
                        Logging.log("E/S iniciada em " + bcp.getProgramName());
                        break;
                    case 'S':
                        bcp.setEstado(Estados.FINALIZADO);
                        tabelaDeProcessos.removeProcesso(bcp.getProgramName());
                        Logging.log(bcp.getProgramName() + " terminado." + " X=" + X + ". Y=" + Y);
                        break;
                    case 'X':
                        X = Integer.parseInt(command.substring(2));
                        break;
                    case 'Y':
                        Y = Integer.parseInt(command.substring(2));
                        break;
                    default:
                        break;
                }
            }

            instrucoes += n_com;
            total_quantum++;

            Logging.log("Interrompendo " + bcp.getProgramName() + " após " + n_com + " instruções");

            bcp.setX(X);
            bcp.setY(Y);

            if(bcp.getEstado() == Estados.EXECUTANDO) {
                bcp.setEstado(Estados.PRONTO);
                filaProntos.add(bcp);
            }
        }

        media_trocas = (float) (total_quantum - 1) / quantidade_processos;

        media_quantums = (float) instrucoes / (total_quantum);

        Logging.log("MEDIA DE TROCAS: " + media_trocas);

        Logging.log("MEDIA DE INSTRUÇÕES: " + media_quantums);

        Logging.log("QUANTUM: " + tabelaDeProcessos.getQuantum());

        Logging.endLog();
    }
}
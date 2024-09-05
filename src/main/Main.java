package main;

import entities.BCP;
import filas.*;

public class Main {
    public static void main(String[] args) {

        // Criacao das estruturas
        int n_com, X, Y;
        FilaBloqueados filaBloqueados = new FilaBloqueados();
        FilaProntos filaProntos = new FilaProntos();
        TabelaDeProcessos tabelaDeProcessos = new TabelaDeProcessos();
        FileHandler filehandler = new FileHandler(tabelaDeProcessos);
        FilaHandler filaHandler = new FilaHandler(filaProntos, filaBloqueados, tabelaDeProcessos);

        filehandler.processar();
        filaHandler.inicializaFilaProntos();

        // Imprime os processos adicionados (teste)
        tabelaDeProcessos.print();

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
            bcp.useCredito();
            X = bcp.getX();
            Y = bcp.getY();
            filaHandler.atualizarBloqueados();

            for(n_com = 0; n_com < tabelaDeProcessos.getQuantum(); n_com++){
                String command = bcp.getNextCommand();
                switch(command.charAt(0)){
                    case 'E':
                        bcp.setEstado(Estados.BLOQUEADO);
                        filaBloqueados.adicionarBloqueado(bcp);
                        break;
                    case 'S':
                        tabelaDeProcessos.removeProcesso(bcp.getId());
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
                if(bcp.getEstado() != Estados.EXECUTANDO) break;
            }

            bcp.setX(X);
            bcp.setY(Y);

            if(bcp.getEstado() == Estados.EXECUTANDO) {
                bcp.setEstado(Estados.PRONTO);
                filaProntos.add(bcp);
            }
        }
    }
}
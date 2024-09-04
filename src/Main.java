public class Main {
    public static void main(String[] args) {

        // Criacao das estruturas
        int n_com;
        ListaBloqueados listaBloqueados = new ListaBloqueados();
        FilaProntos filaProntos = new FilaProntos();
        TabelaDeProcessos tabelaDeProcessos = new TabelaDeProcessos();
        FileHandler filehandler = new FileHandler(tabelaDeProcessos);

        filehandler.processar();
        tabelaDeProcessos.inicializaFilaProntos(filaProntos);

        // Imprime os processos adicionados (teste)
        tabelaDeProcessos.print();

        // Laco principal
        while(tabelaDeProcessos.exists()){
            if(filaProntos.isEmpty()) {
                listaBloqueados.atualizarBloqueados(filaProntos);
                continue;
            }
            if(filaProntos.valorCreditoMaximo() == 0 && listaBloqueados.isEmpty()){
                tabelaDeProcessos.resetarCreditos();
            }
            BCP bcp = filaProntos.getNext();
            bcp.setEstado(Estados.EXECUTANDO);
            listaBloqueados.atualizarBloqueados(filaProntos);

            for(n_com = 0; n_com < filehandler.getQuantum(); n_com++){
                String command = bcp.getNextCommand();
                switch(command){
                    case "E/S":
                        break;
                    case "SAÍDA":
                        break;
                }
            }
        }
    }
}
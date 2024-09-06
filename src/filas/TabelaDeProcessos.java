package filas;

import entities.BCP;

import java.util.HashMap;

/* Classe utilizada para gerenciar todos os processos/BCP */
public class TabelaDeProcessos {
    protected final HashMap<String, BCP> processos;
    private int quantum;

    /* Construtor */
    public TabelaDeProcessos() {
        this.processos = new HashMap<>();
    }

    /* Getter */
    public BCP getProcesso(int pos){
        for(BCP bcp : processos.values()){
            if (bcp.getId() == pos) return bcp;
        }
        return null;
    }

    public int getQuantum(){
        return this.quantum;
    }

    /* Setter */
    protected void setQuantum(int quantum){
        this.quantum = quantum;
    }

    /* Outros metodos */
    public void adicionaProcesso(BCP processo){
        this.processos.put(processo.getProgramName(), processo);
    }

    public void removeProcesso(String name){
        this.processos.remove(name);
    }

    public boolean exists(){
        return !processos.isEmpty();
    }

    public void resetarCreditos(){
        for(BCP bcp : processos.values()) {
            bcp.resetarCreditos();
        }
    }

    /* Print */
    public void print(){
        System.out.println("Tabela de Processos:");
        for(BCP bcp : processos.values()) {
            bcp.print();
        }
    }
}
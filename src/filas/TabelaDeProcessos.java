package filas;

import entities.BCP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TabelaDeProcessos {
    protected final HashMap<String, BCP> processos;
    private int quantum;

    public TabelaDeProcessos() {
        this.processos = new HashMap<>();
    }

    public void addProcesso(BCP processo){
        this.processos.put(processo.getProgramName(), processo);
    }

    public void removeProcesso(String name){
        this.processos.remove(name);
    }

    public BCP getProcesso(int pos){
        for(BCP bcp : processos.values()){
            if (bcp.getId() == pos) return bcp;
        }
        return null;
    }

    public boolean exists(){
        return !processos.isEmpty();
    }

    public void resetarCreditos(){
        for(BCP bcp : processos.values()) {
            bcp.resetarCreditos();
        }
    }
    public int getQuantum(){
        return this.quantum;
    }

    protected void setQuantum(int quantum){
        this.quantum = quantum;
    }

    // Printar informacoes de todos os processos
    public void print(){
        System.out.println("Tabela de Processos:");
        for(BCP bcp : processos.values()) {
            bcp.print();
        }
    }
}
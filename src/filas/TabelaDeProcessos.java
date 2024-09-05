package filas;

import entities.BCP;

import java.util.ArrayList;

public class TabelaDeProcessos {
    protected final ArrayList<BCP> processos;
    private int quantum;

    public TabelaDeProcessos() {
        this.processos = new ArrayList<>();
    }

    public void addProcesso(BCP processo){
        this.processos.add(processo);
    }

    public void removeProcesso(int pos){
        this.processos.remove(pos);
    }

    public BCP getProcesso(int pos){
        return this.processos.get(pos);
    }

    public boolean exists(){
        return !processos.isEmpty();
    }

    public void resetarCreditos(){
        for (BCP processo : this.processos) {
            processo.resetarCreditos();
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
        for (BCP processo : this.processos) {
            processo.print();
        }
    }
}
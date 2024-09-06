package filas;

import entities.BCP;

import logging.Logging;
import java.util.PriorityQueue;

/* Classe utilizada para gerenciar os processos prontos */
public class FilaProntos {
    private final PriorityQueue<BCP> priorityQueue;

    /* Construtor */
    public FilaProntos() {
        this.priorityQueue = new PriorityQueue<BCP>();
    }

    /* Getter */
    public BCP getNext(){
        return priorityQueue.poll();
    }

    public int getSize(){
        return this.priorityQueue.size();
    }

    /* Outros metodos */
    public boolean isEmpty(){
        return this.priorityQueue.isEmpty();
    }

    public void add(BCP bcp) {
        this.priorityQueue.add(bcp);
    }

    public int valorCreditoMaximo(){
        BCP bcp = this.priorityQueue.peek();
        if (bcp == null) return 0;
        return bcp.getCreditos();
    }

    /* Log */
    public void logFilaProntos(){
        PriorityQueue<BCP> p2 = new PriorityQueue<>(this.priorityQueue);
        while (!p2.isEmpty()){
            Logging.log("Carregando " + p2.poll().getProgramName());
        }
    }
}

import java.util.PriorityQueue;

public class FilaProntos {
    private final PriorityQueue<BCP> priorityQueue;

    public FilaProntos() {
        this.priorityQueue = new PriorityQueue<BCP>();
    }

    public boolean isEmpty(){
        return this.priorityQueue.isEmpty();
    }

    public void add(BCP bcp) {
        this.priorityQueue.add(bcp);
    }

    public BCP getNext(){
        return priorityQueue.poll();
    }

    public int valorCreditoMaximo(){
        BCP bcp = this.priorityQueue.peek();
        if (bcp == null) return 0;
        return bcp.getCreditos();
    }
}

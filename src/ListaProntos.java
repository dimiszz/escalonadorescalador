import java.util.PriorityQueue;

public class ListaProntos {
    private final PriorityQueue<BCP> priorityQueue;

    public ListaProntos() {
        this.priorityQueue = new PriorityQueue<BCP>();
    }

    public void add(BCP bcp) {
        this.priorityQueue.add(bcp);
    }

    public BCP getNext(){
        return priorityQueue.poll();
    }
}

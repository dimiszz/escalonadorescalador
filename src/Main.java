import java.util.PriorityQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PriorityQueue<BCP> a = new PriorityQueue<BCP>();


        BCP b = new BCP(10);
        b.setPrioridade(10);

        BCP b2 = new BCP(10);
        b2.setPrioridade(2);

        BCP b3 = new BCP(10);
        b3.setPrioridade(3);

        BCP b4 = new BCP(10);
        b4.setPrioridade(421142134);

        a.add(b);
        a.add(b2);
        a.add(b4);
        a.add(b3);

        for(int i = 0; i < 4; i++){
            System.out.println(a.poll().getCreditos());
        }



    }
}
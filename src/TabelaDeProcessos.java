import java.util.ArrayList;

public class TabelaDeProcessos {
    private final ArrayList<BCP> processos;

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

    public void inicializaFilaProntos(FilaProntos fila){
        for (BCP processo : this.processos) {
            fila.add(processo);
        }
    }

    public void resetarCreditos(){
        for (BCP processo : this.processos) {
            processo.resetarCreditos();
        }
    }
}
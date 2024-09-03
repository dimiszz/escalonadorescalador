import java.util.ArrayList;

public class TabelaDeProcessos {
    private final ArrayList<BCP> processos;

    public TabelaDeProcessos(int qtdProcessos) {
        this.processos = new ArrayList<>(qtdProcessos);
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

    public void setPrioridades(ArrayList<Integer> prioridades){
        for(int i = 0; i < this.processos.size(); i++){
            this.processos.get(i).setPrioridade(prioridades.get(i));
        }
    }

    public void inicializaFilaProntos(ListaProntos fila){
        for (BCP processo : this.processos) {
            fila.add(processo);
        }
    }
}
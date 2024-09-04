import java.util.ArrayList;
import java.util.Comparator;

public class BCP implements Comparable<BCP> {
    private int pc;
    private final ArrayList<String> comandos;
    private Estados estado;
    private int X;
    private int Y;
    private int prioridade;
    private int creditos;

    public BCP(int qtdComandos){
        this.comandos = new ArrayList<String>(qtdComandos);
        this.estado = Estados.PRONTO;
        this.pc = 0;
    }

    public int getCreditos(){
        return creditos;
    }

    public void resetarCreditos(){
        this.creditos = this.prioridade;
    }

    public void useCredito(){
        this.creditos -= 1;
    }

    public void setPrioridade(int prioridade){
        this.prioridade = prioridade;
        resetarCreditos();
    }

    public Estados getEstado(){
        return this.estado;
    }

    public void setEstado(Estados estado){
        this.estado = estado;
    }

    public void setX(int x){
        this.X = x;
    }

    public void setY(int y){
        this.Y = y;
    }

    public int getX(){
        return this.X;
    }

    public int getY(){
        return this.Y;
    }

    public void addCommand(String comando){
        this.comandos.add(comando);
    }

    public String getNextCommand(){
        this.pc++;
        return comandos.get(this.pc);
    }

    public String getProgramName(){
        return comandos.getFirst();
    }

    public int compareTo(BCP bcp){
        return Integer.compare(bcp.creditos,this.creditos);
    }

}

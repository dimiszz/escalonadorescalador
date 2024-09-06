package entities;

import main.Estados;

import java.util.ArrayList;

/* Classe utilizada para implementar os BCPs */
public class BCP implements Comparable<BCP> {
    private final ArrayList<String> comandos;
    private Estados estado;
    private int prioridade;
    private int creditos;
    private int pc;
    private int id;
    private int X;
    private int Y;

    /* Construtor */
    public BCP(int qtdComandos, int id){
        this.comandos = new ArrayList<String>(qtdComandos);
        this.estado = Estados.PRONTO;
        this.pc = 0;
        this.id = id;
        this.X = 0;
        this.Y = 0;
    }

    /* Getter */
    public String getNextCommand(){
        this.pc++;
        return comandos.get(this.pc);
    }

    public String getProgramName(){
        return comandos.getFirst();
    }

    public Estados getEstado(){
        return this.estado;
    }

    public int getCreditos(){
        return creditos;
    }

    public int getId(){
        return this.id;
    }

    public int getX(){
        return this.X;
    }

    public int getY(){
        return this.Y;
    }

    /* Setter */
    public void setPrioridade(int prioridade){
        this.prioridade = prioridade;
        resetarCreditos();
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

    /* Outros metodos */
    public void resetarCreditos(){
        this.creditos = this.prioridade;
    }

    public void useCredito(){
        this.creditos -= 1;
    }

    public void addCommand(String comando){
        this.comandos.add(comando);
    }

    public int compareTo(BCP bcp){
        return Integer.compare(bcp.creditos,this.creditos);
    }

    /* Print */
    public void print(){
        System.out.println("\nPC: " + this.pc);
        System.out.println("Estado: " + this.estado);
        System.out.println("X: " + this.X);
        System.out.println("Y: " + this.Y);
        System.out.println("Prioridade: " + this.prioridade);
        System.out.println("Creditos: " + this.creditos);
        System.out.println("Comandos:");
        for (String comando : this.comandos) {
            System.out.println(comando);
        }
    }

    public void printNome(){
        System.out.println("Nome:" + this.getProgramName());
    }
}

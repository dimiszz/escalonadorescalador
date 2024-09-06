package entities;

/* Classe de bloqueados que tem o tempo de espera */
public class Bloqueado {
    private int lifetime;
    private BCP bcp;

    /* Construtor */
    public Bloqueado(BCP bcp) {
        this.lifetime = 2;
        this.bcp = bcp;
    }

    /* Getter */
    public BCP getBcp(){
        return this.bcp;
    }

    /* Outros metodos */
    public boolean isDead(){
        return this.lifetime == 0;
    }

    public void damage(){
        lifetime--;
    }
}

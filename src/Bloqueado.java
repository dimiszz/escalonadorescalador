public class Bloqueado {
    private int lifetime;
    private BCP bcp;

    public Bloqueado(BCP bcp) {
        this.lifetime = 2;
        this.bcp = bcp;
    }

    public BCP getBcp(){
        return this.bcp;
    }

    public boolean isDead(){
        return this.lifetime == 0;
    }

    public void damage(){
        lifetime--;
    }
}

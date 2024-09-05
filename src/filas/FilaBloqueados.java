package filas;

import entities.Bloqueado;
import entities.BCP;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FilaBloqueados {
    protected final List<Bloqueado> bloqueados;

    public FilaBloqueados() {
        bloqueados = new LinkedList<>();
    }

    public void adicionarBloqueado(BCP bcp) {
        Bloqueado bloqueado = new Bloqueado(bcp);
        bloqueados.add(bloqueado);
    }

    public boolean isEmpty(){
        return bloqueados.isEmpty();
    }
}
package filas;

import entities.Bloqueado;
import entities.BCP;

import java.util.LinkedList;
import java.util.List;

/* Classe utilizada para gerenciar os processos bloqueados */
public class FilaBloqueados {
    protected final List<Bloqueado> bloqueados;

    /* Construtor */
    public FilaBloqueados() {
        bloqueados = new LinkedList<>();
    }

    /* Outros metodos */
    public void adicionarBloqueado(BCP bcp) {
        Bloqueado bloqueado = new Bloqueado(bcp);
        bloqueados.add(bloqueado);
    }

    public boolean isEmpty(){
        return bloqueados.isEmpty();
    }
}
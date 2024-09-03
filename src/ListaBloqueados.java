import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListaBloqueados {
    private final List<Bloqueado> bloqueados;

    public ListaBloqueados() {
        bloqueados = new LinkedList<>();
    }

    public void adicionarBloqueado(Bloqueado bloqueado) {
        bloqueados.add(bloqueado);
    }

    public void atualizarBloqueado(ListaProntos listaProntos) {
        for (Iterator<Bloqueado> iterator = bloqueados.iterator(); iterator.hasNext();) {
            Bloqueado bloqueado = iterator.next();
            bloqueado.damage();
            if(bloqueado.isDead()) {
                iterator.remove();
                listaProntos.add(bloqueado.getBcp());
            }

        }
    }
}
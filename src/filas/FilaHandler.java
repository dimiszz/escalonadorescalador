package filas;

import entities.BCP;
import entities.Bloqueado;

import java.util.Iterator;

public class FilaHandler {
     private FilaProntos prontos;
     private FilaBloqueados bloqueados;
     private TabelaDeProcessos processos;

     public FilaHandler(FilaProntos prontos, FilaBloqueados bloqueados, TabelaDeProcessos processos) {
          this.prontos = prontos;
          this.bloqueados = bloqueados;
          this.processos = processos;
     }

     public void inicializaFilaProntos(){
          for (BCP processo : this.processos.processos) {
               prontos.add(processo);
          }
     }

     public void atualizarBloqueados() {
          for (Iterator<Bloqueado> iterator = bloqueados.bloqueados.iterator(); iterator.hasNext();) {
               Bloqueado bloqueado = iterator.next();
               bloqueado.damage();
               if(bloqueado.isDead()) {
                    iterator.remove();
                    prontos.add(bloqueado.getBcp());
               }
          }
     }
}

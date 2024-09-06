package filas;

import entities.BCP;
import entities.Bloqueado;
import main.Estados;

import java.util.Iterator;

/* classe utilizada para gerenciar as filas de forma conjunta */
public class FilaHandler {
     private FilaProntos prontos;
     private FilaBloqueados bloqueados;
     private TabelaDeProcessos processos;

     public FilaHandler(FilaProntos prontos, FilaBloqueados bloqueados, TabelaDeProcessos processos) {
          this.prontos = prontos;
          this.bloqueados = bloqueados;
          this.processos = processos;
     }

     /* Coloca os processos na fila  */
     public void inicializaFilaProntos(){
          for(BCP bcp : processos.processos.values()) {
               prontos.add(bcp);
          }
     }

     /* gerencia a fila de bloqueados, atualizando após um quantum
      e removendo caso tenha acabado seu tempo */
     public void atualizarBloqueados() {
          for (Iterator<Bloqueado> iterator = bloqueados.bloqueados.iterator(); iterator.hasNext();) {
               Bloqueado bloqueado = iterator.next();
               bloqueado.damage();
               if(bloqueado.isDead()) {
                    iterator.remove();
                    bloqueado.getBcp().setEstado(Estados.PRONTO);
                    prontos.add(bloqueado.getBcp());
               }
          }
     }

}

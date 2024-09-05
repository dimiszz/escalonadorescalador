package filas;

import entities.BCP;
import entities.Bloqueado;
import logging.Logging;
import main.Estados;

import java.util.Iterator;
import java.util.Map;

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
          for(BCP bcp : processos.processos.values()) {
               prontos.add(bcp);
          }
     }

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

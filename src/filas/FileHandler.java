package filas;

import entities.BCP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* Classe utilizada para gerenciar os arquivos de entrada
   (programas, prioridades e quantum) */
public class FileHandler {
    private TabelaDeProcessos tabelaDeProcessos;

    /* Construtor */
    public FileHandler(TabelaDeProcessos tabelaDeProcessos) {
        this.tabelaDeProcessos = tabelaDeProcessos;
    }

    /* Adiciona os programas na tabela de processos e cria o BCP */
    private void processarProgramas() {
        BufferedReader reader;
        File[] files = new File("./programas").listFiles();
        int id = 0;
        for (File file : files) {
            if (file.isFile()) {
                try {
                    reader = new BufferedReader(new FileReader("./programas/" + file.getName()));
                    if (file.getName().startsWith("prioridades") || file.getName().startsWith("quantum"))
                        continue;
                    BCP bcp = new BCP(24, id);
                    id++;
                    String line = reader.readLine();
                    while (line != null) {
                        bcp.addCommand(line);
                        line = reader.readLine();
                    }
                    reader.close();
                    this.tabelaDeProcessos.adicionaProcesso(bcp);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }

    /* Adiciona as prioridades aos seus devidos programas */
    private void processarPrioridades(){
        BufferedReader reader;
        int counter = 0;
        try {
            reader = new BufferedReader(new FileReader("./programas/prioridades.txt"));
            String line = reader.readLine();
            while (line != null) {
                this.tabelaDeProcessos.getProcesso(counter).setPrioridade(Integer.parseInt(line));
                counter++;
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /* Armazena o tamanho do quantum que sera utilizado */
    protected void processarQuantum(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("./programas/quantum.txt"));
            String line = reader.readLine();
            this.tabelaDeProcessos.setQuantum(Integer.parseInt(line));
            reader.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /* Funcao que sera chamada na main para processar os arquivos */
    public void processar(){
        this.processarProgramas();
        this.processarPrioridades();
        this.processarQuantum();
    }
}

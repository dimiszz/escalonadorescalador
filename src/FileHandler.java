import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileHandler {
    private TabelaDeProcessos tabelaDeProcessos;
    private int quantum;

    public FileHandler(TabelaDeProcessos tabelaDeProcessos) {
        this.tabelaDeProcessos = tabelaDeProcessos;
    }

    /// OTIMIZAR CONTADOR DE LINHAS!
    private void processarArquivos() {
        BufferedReader reader;
        File[] files = new File("./programas").listFiles();
        for (File file : files) {
            if (file.isFile()) {
                try {
                    reader = new BufferedReader(new FileReader("./programas/" + file.getName()));
                    if (file.getName().startsWith("prioridades") || file.getName().startsWith("quantum"))
                        continue;
                    BCP bcp = new BCP(24);
                    String line = reader.readLine();
                    while (line != null) {
                        bcp.addCommand(line);
                        line = reader.readLine();
                    }
                    reader.close();
                    this.tabelaDeProcessos.addProcesso(bcp);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }

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

    private void processarQuantum(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("./programas/quantum.txt"));
            String line = reader.readLine();
            this.quantum = Integer.parseInt(line);
            reader.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void processar(){
        this.processarArquivos();
        this.processarPrioridades();
        this.processarQuantum();
    }

    public int getQuantum() {
        return quantum;
    }
}

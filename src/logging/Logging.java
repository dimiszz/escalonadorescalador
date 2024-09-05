package logging;

import java.io.FileWriter;
import java.io.IOException;

public class Logging {
    private static FileWriter writter;

    public static void startLog(int qtdQuantum) {
        try {
            writter = new FileWriter(String.format("log%02d.txt", qtdQuantum));
        }
        catch (IOException e) {
            System.out.println("Erro criando o arquivo de log.");
        }
    }

    public static void log(String str){
        try{
            writter.write(str + "\n");
        }
        catch(IOException e){
            System.out.println("Erro ocorreu no log:" + str);
            e.printStackTrace();
        }
    }

    public static void endLog(){
        try {
            writter.close();
        } catch (IOException e) {
            System.out.println("Não foi possível fechar o log.");
        }
    }
}

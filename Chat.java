package syncmeet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Chat {

    public static void enviarMensagem(String nomeEquipe, String remetente, String mensagem) {
        String arquivoChat = "C:\\Users\\vitor\\OneDrive\\Documentos\\"+ nomeEquipe + "_Chat.txt";
        String registroMensagem = remetente + ": " + mensagem;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoChat, true))) {
            writer.write(registroMensagem);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exibirMensagens(String nomeEquipe) {
        String arquivoChat = "C:\\Users\\vitor\\OneDrive\\Documentos\\"+ nomeEquipe + "_Chat.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoChat))) {
            String mensagem;
            while ((mensagem = reader.readLine()) != null) {
                System.out.println(mensagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


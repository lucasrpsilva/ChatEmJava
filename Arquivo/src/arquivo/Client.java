package arquivo;
//Vitor Loredo e Lucas rezende / 31609546 e 31682073
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
            System.out.println("Conectando com servidor");
            //Conecta com o servidor
            InputStream clientSocket = new Socket("172.16.19.172",6789).getInputStream();

            System.out.println("Criando o novo arquivo");
            //Cria o arquivo que vai ser copiado, pode colocar qualquer coisa, nesse caso um jpg
            FileOutputStream fos = new FileOutputStream(new File("copy.jpg"));
            System.out.println("Criado copy.jpg");

            //Tamanho de leitura
            byte[] cbuffer = new byte[1024];
            int bytesRead;

            System.out.println("Copiando");
            //Lendo o arquivo
            while ((bytesRead = clientSocket.read(cbuffer)) != -1) {
                    fos.write(cbuffer, 0, bytesRead);
                    fos.flush();
            }
            
            System.out.println("Arquivo copiado!");
            
            fos.close();
            clientSocket.close();
            //Fecha Socket e arquivo
            //Os arquivos ficam na pasta do projeto
	}
}

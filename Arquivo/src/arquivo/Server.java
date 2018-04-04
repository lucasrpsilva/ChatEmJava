package arquivo;
//Vitor Loredo e Lucas rezende / 31609546 e 31682073
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.FileWriter;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException {
            String nome;
            Scanner sc = new Scanner(System.in); 
            
            //Ler o arquivo no qual vc quer enviar antes
            System.out.println("Digite o arquivo jpg que deseja");   
            nome = sc.next();
            
            System.out.println("O tipo dele .jpg... etc");   
            nome+= sc.next();
            
            System.out.println("Nome do arquivo");
            System.out.println(nome);
            
            //PARA COLOCAR INFINITO MUDE O ACCEPT PARA BAIXO
            System.out.println("Conectado");
            //Cria o Socket e accept
            Socket connectionSocket  = new ServerSocket(6789).accept();
            
            if(connectionSocket!=null){
                System.out.println("Conexao recebida pelo cliente");
            }


            FileInputStream fileIn = new FileInputStream(new File(nome));            
            System.out.println("Lendo arquivo para enviar");

            System.out.println("Canal criado");
            //Cria o caminho entre eles
            OutputStream socketOut = connectionSocket.getOutputStream();

            //Nao sei bem comofunciona isso, mas criando tamanho de leitura
            byte[] cbuffer = new byte[1024];
            int bytesRead;

            System.out.println("Enviando Arquivo...");
            //Ele o arquivo e envia
            while ((bytesRead = fileIn.read(cbuffer)) != -1) {
                    socketOut.write(cbuffer, 0, bytesRead);
                    socketOut.flush();
            }

            System.out.println("Arquivo Enviado!");

            //Fecha o socket
            socketOut.close();
            
            //bruno.rodrigues@makenzie.br
            //Os arquivos ficam na pasta do projeto
		
	}

}

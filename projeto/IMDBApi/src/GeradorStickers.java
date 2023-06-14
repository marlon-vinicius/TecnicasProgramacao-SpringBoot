import java.io.File;
import java.io.IOException;
import java.io.InputStream;
//import java.net.URL;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

public class GeradorStickers {
    public void gerarStickers(InputStream inputStream, String nomeArquivo) throws IOException {
        // leitura da imagem "local"
        //BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));

        // leitura da imagem "URL"
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_Ratio0.6716_AL_.jpg").openStream();
        


        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        //criar uma nova imagem em memória com transparencia e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura,novaAltura,BufferedImage.TYPE_INT_ARGB);

        // criar a imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal,0,0,null);
        // configurar a fonte para escrever na imagem
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);
        // escrever uma mensagem na nova imagem
        graphics.drawString("TOP 250 FILMES", 200,novaAltura - 80);

        

        // escrever a nova imagem em arquivo
        ImageIO.write(novaImagem,"png",new File("saida/"+nomeArquivo));
    }

    // public static void main(String[] args) throws IOException {
    //     var gerador = new GeradorStickers();
    //     gerador.gerarStickers();
    // }
    
}

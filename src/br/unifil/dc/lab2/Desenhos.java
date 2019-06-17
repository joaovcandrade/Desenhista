package br.unifil.dc.lab2;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Random;


/**
 * Write a description of class Desenhos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Desenhos
{
    /**
     * Desenha uma arte aletória.
     *
     * @param pincel Graphics2D.
     * @param dim atual dimensão da tela.
     */
    public static void desenhoLivre(Graphics2D pincel, Dimension dim) {

        Random random = new Random();

        for (int i = 0; i < 10 ; i++){
            pincel.setColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
            pincel.fillOval(
                  random.nextInt(800), random.nextInt(600),
                  random.nextInt(300), random.nextInt(300)
            );
            pincel.fillRect(
                  random.nextInt(800), random.nextInt(600),
                  random.nextInt(300), random.nextInt(300)
            );
        }

        //throw new UnsupportedOperationException("O aluno ainda não implementou este método.");
    }

    /**
     * Desenha um asterisco.
     *
     * @param pincel Graphics2D.
     * @param dim atual dimensão da tela.
     */
    public static void desenharAsterisco(Graphics2D pincel, Dimension dim) {

        pincel.setStroke(new BasicStroke(55.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        pincel.drawLine(120,120,640,490);
        pincel.drawLine(640,120,120,490);
        pincel.drawLine(380,60,380,550);
        pincel.drawLine(60,305,700,305);

        //throw new UnsupportedOperationException("O aluno ainda não implementou este método.");
    }

    /**
     * Desenha 3 Smiles.
     * Smile sorrindo, normal e bravo, respectivamente.
     *
     * @param pincel Graphics2D.
     * @param dim atual dimensão da tela.
     */
    public static void desenharSmiles(Graphics2D pincel, Dimension dim){

        desenhaSmile(pincel, "sorrindo", Color.green, 0);
        desenhaSmile(pincel, "normal", Color.yellow, 1);
        desenhaSmile(pincel, "bravo", Color.red, 2);

    }

    /**
     * Desenha um Slime com expressão normal ou sorrindo ou bravo.
     * Caso a expressão não corresponda, será por padrão um smile sorrindo.
     *
     * Limitações:
     * A posição deve ser um inteiro de 0 a 2.
     *
     * @param pincel Graphics2D.
     * @param expressao String que corresponda a expressão do smile ("sorrindo" ou "normal" ou "bravo").
     * @param cor Color do smile.
     * @param posicao inteiro da posição(ordem) de desenho do smiles, de 0 a 2.
     */
    public static void desenhaSmile(Graphics2D pincel, String expressao, Color cor, int posicao){

        assert (posicao >=0 && posicao <= 2) : "A posição deve ser um inteiro de 0 a 2";

        int[] desloc = {0, 210, 420};

        pincel.setColor(cor);
        pincel.fillOval(60+desloc[posicao],60, 150, 150);
        pincel.setColor(Color.black);

        pincel.setStroke(new BasicStroke(5.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

            switch(expressao){
                case "sorrindo":
                    pincel.fillArc(85+desloc[posicao], 120,100,70, 0, -180);
                    break;
                case "normal":
                    pincel.drawLine(85+desloc[posicao], 170,180+desloc[posicao],170);
                    break;
                case "bravo":
                    pincel.drawPolyline(new int[]{100+desloc[posicao],135+desloc[posicao], 170+desloc[posicao]}, new int[]{80, 100, 80}, 3);
                    pincel.drawArc(85+desloc[posicao], 150,100,70, 20, 140);
                    break;
                default:
                    pincel.fillArc(85+desloc[posicao], 120,100,70, 0, -180);
                    break;
            }

        pincel.drawOval(60+desloc[posicao],60, 150, 150);
        pincel.fillOval(85+desloc[posicao], 100, 30,30);
        pincel.fillOval(155+desloc[posicao], 100, 30,30);


    }

    /**
     * Desenha um monitor e um gabinete torre, com três baias e espaço para 2 leitores de disquetes,
     * dois conectores usb, conectores de microfone e fone.
     * @param pincel Graphics2D.
     * @param dim dimensão da tela.
     */
    public static void desenharComputador(Graphics2D pincel, Dimension dim){

        pincel.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        pincel.drawRect(80,80,280,200);
        pincel.fillRect(90,90,260,180);
        pincel.drawRect(205,280, 30, 25);
        pincel.drawRoundRect(120, 305, 195,15, 30,180);
        pincel.drawRect(380, 70, 125, 255);
        pincel.drawRect(400, 90, 85, 10);
        pincel.drawRect(400, 100, 85, 10);
        pincel.drawRect(400, 110, 85, 10);
        pincel.drawRect(400, 180, 85, 20);
        pincel.drawRect(400, 200, 85, 20);
        pincel.drawRect(413, 290, 13, 7);
        pincel.drawRect(430, 290, 13, 7);
        pincel.drawLine(380, 225, 505, 225);
        pincel.drawString("AlunoTEC",420, 250);
        pincel.drawOval(432, 260, 20,20);
        pincel.drawOval(448, 290, 7, 7);
        pincel.drawOval(460, 290, 7, 7);
        pincel.setColor(Color.green);
        pincel.fillOval(448, 290, 7, 7);
        pincel.setColor(Color.pink);
        pincel.fillOval(460, 290, 7, 7);
        pincel.setColor(Color.black);


    }

    /**
     * Desenha a bandeira do brasil 'auto-redimensonável' ao tamanho da tela.
     *
     * @param pincel Graphics2D.
     * @param dim dimensão da tela.
     */
    public static void desenharBandeira(Graphics2D pincel, Dimension dim){
        int x1 = Math.round(800/800.0f * dim.width);
        int y1 = Math.round(600/600.0f * dim.height);
        pincel.setColor(Color.decode("#009c3b"));
        pincel.fillRect(0,0,x1,y1);


        x1 = Math.round(400/800.0f *dim.width);
        int x2 = Math.round(760/800.0f *dim.width);
        int x3 = Math.round(40/800.0f *dim.width);
        y1 = Math.round(300/600.0f *dim.height);
        int y2 = Math.round(560/600.0f *dim.height);
        int y3 = Math.round(40/600.0f *dim.height);

        int[] x = {x3, x1, x2, x1, x3};
        int[] y = {y1, y3, y1, y2, y1};
        pincel.setColor(Color.yellow);
        pincel.fillPolygon(x, y, 5);


        //circulo
        x1 = Math.round(250/800.0f *dim.width);
        y1 = Math.round(155/600.0f *dim.height);
        x2 = Math.round(300/800.0f *dim.width);
        y2 = Math.round(300/600.0f *dim.height);
        pincel.setColor(Color.decode("#002776"));
        pincel.fillOval(x1, y1, x2, y2);


        //faixa
        x1 = Math.round(-140/800.0f *dim.width);
        y1 = Math.round(270/600.0f *dim.height);
        x2 = Math.round(702/800.0f *dim.width);
        y2 = Math.round(80/600.0f *dim.height);
        x3 = Math.round((7/800.0f *dim.width * 7/800.0f *dim.height)/2);
        pincel.setColor(Color.white);
        pincel.setStroke(new BasicStroke(x3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        pincel.drawArc(x1,y1, x2,y2, 20,61);


        //escrita
        x2 = Math.round(15/800.0f *dim.width);
        y2 = Math.round(15/600.0f *dim.height);
        pincel.setFont(new Font("TimesRoman", Font.BOLD, (x2+y2)/2));
        pincel.setColor(Color.decode("#009c3b"));
        String[] text = {"O","R","D","E","M"," ","E"," ","P","R","O","G","R","E","S","S","O"};
        int deslocamento = 0;
        for (int i=0; i< text.length; i++){
            deslocamento = 15 * i;
            x1 = Math.round((280+deslocamento)/800.0f *dim.width);
            y1 = Math.round((275+deslocamento/12)/600.0f *dim.height);
            pincel.drawString(text[i], x1, y1);
        }

        /**
         * x1 = Math.round(250/800.0f *dim.width);
         *         y1 = Math.round(155/600.0f *dim.height);
         *         x2 = Math.round(300/800.0f *dim.width);
         *         y2 = Math.round(300/600.0f *dim.height);
         */

        //estrelas
        pincel.setColor(Color.white);
        Random rand = new Random();
        x1 = Math.round(470/800.0f *dim.width);
        y1 = Math.round(250/600.0f *dim.height);
        x2 = Math.round(5/800.0f *dim.width);
        y2 = Math.round(5/600.0f *dim.height);
        pincel.fillOval(x1, y1, x2,y2); //estrela cima faixa.
        for (int i = 0; i < 26; i++){ //estrelas baixo faixa.
            int estrelaX = rand.nextInt((500 - 300) + 1) + 300;
            int estrelaY = rand.nextInt((420 - 300) + 1) + 300;
            x1 = Math.round(estrelaX/800.0f *dim.width);
            y1 = Math.round(estrelaY/600.0f *dim.height);
            pincel.fillOval(x1, y1, x2,y2);
        }



    }

    /**
     * Desenha 16 prédios coloridos de até 12 andares e 15 até janelas, aletoriamente.
     * Os prédios são desenhados da esquerda para direita, independente do tamanho da tela.
     *
     * @param pincel Graphics2D.
     * @param dim dimensão da tela.
     *
     */
    public static void desenharPredios(Graphics2D pincel, Dimension dim){

        Random random = new Random();
        for(int i = 0; i < 16; i++){
            desenhaPredio( pincel,  dim, i,  random.nextInt(11)+1,  random.nextInt(14)+1);
        }

    }

    /**
     * Desenha um prédio em uma n posição, com uma n quantidade de andares e n janelas.
     *
     * Limitações:
     * A Posição(ordem) do prédio deve ser um inteiro positivo ou nulo.
     * A quantidade de andar deve ser inteiro positivo.
     * A quantidade de janelas deve ser inteiro positivo e o máximo é  15.
     *
     *
     * @param pincel Graphics2D.
     * @param dim dimensão da tela.
     * @param posiX Inteiro maior que zero que indica posição(ordem) onde será desenhada o prédio.
     * @param andares Inteiro que indica a quantidade de andares do prédio.
     * @param janelas Inteiro positivo que indica a quantidade de janelas no prédio.
     */
    public static void desenhaPredio(Graphics2D pincel, Dimension dim, int posiX, int andares, int janelas){

        assert (posiX >= 0) : "A Posição(ordem) do prédio deve ser um inteiro positivo ou nulo.";
        assert (andares > 0) : "A quantidade de andares deve ser um inteiro positivo não nulo";
        assert (janelas > 0 && janelas <= 15) :"A quantidade de andares deve ser um inteiro positivo não nulo menor que 15";

        posiX = 117*posiX; //deslocamento horizontal.
        int posiY = 50; //deslocamento vertical.

        //COR
        Random random = new Random();
        final int red = random.nextInt(256);
        final int green = random.nextInt(256);
        final int blue = random.nextInt(256);
        Color colorStronger = new Color((red+75)/2,(green+75)/2,(blue+103)/2);
        Color colorLight = new Color(red, green, blue);


        //Térreo
        int solo = dim.height - 50;
        pincel.setColor(colorStronger);
        pincel.fillRect(posiX, solo, 100,50);

        //Porta
        int x = posiX+25;
        int y = dim.height - 25;
        pincel.setColor(Color.lightGray);
        pincel.fillRect(x, y, 50,25);
        pincel.setColor(colorStronger);
        pincel.drawLine(x+25, y, x+25, y+24);

        //Andares e Janelas
        int divisaoJanelas = (100/janelas);
        int recuo = (divisaoJanelas/2)+2;

        for(int i = 1; i <= andares; i++){
             y = solo-(posiY*i);

            pincel.setColor(i%2==0? colorStronger : colorLight);
            pincel.fillRect(posiX, y, 100,50);


            for(int j = 1; j <= janelas; j++){

                pincel.setColor(Color.yellow);
                pincel.fillRect(posiX+((divisaoJanelas*j)- recuo), y+25, 6,8);
            }

        }

    }


    /**
     * Desenha um polígono.
     * @param pincel Graphics2D.
     * @param dim dimensão da tela.
     */
    public static void desenharPoligono(Graphics2D pincel, Dimension dim){

        int[] x = {60, 720, 60, 60};
        int[] y = {60, 520, 520, 60};

        pincel.fillPolygon(x, y, 4);

    }

}

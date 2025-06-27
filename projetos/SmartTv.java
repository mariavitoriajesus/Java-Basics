package projetos;

public class SmartTv {
    boolean ligada = false;
    int canal =1;
    int volume = 25;
    public void ligar () {
        ligada = true;
    }
    public void desligar() {
        ligada = false;
    }
    public void aumentarVolume() {
        volume++;
    }
    public void diminuirVolume() {
        volume--;
    }
    public void mudarCanalAumentar() {
        canal++;
    }
    public void mudarCanalDiminuir() {
        canal--;
    }
    public void mudarCanal(int novoCanal) {
        canal = novoCanal;
    }
    public static void main(String[] args) {
        SmartTv smartTv = new SmartTv();

        smartTv.mudarCanal(34);

        smartTv.diminuirVolume();
        smartTv.diminuirVolume();
        smartTv.diminuirVolume();

        System.out.println("a tv está ligada? " + smartTv.ligada);
        System.out.println("volume atual: " + smartTv.volume);
        System.out.println("Canal atual: " + smartTv.canal);

        smartTv.ligar();
        System.out.println("a tv está ligada? " + smartTv.ligada);

        smartTv.desligar();
        System.out.println("a tv está ligada? " + smartTv.ligada);

        smartTv.aumentarVolume();
        smartTv.aumentarVolume();
        System.out.println("volume atual: " + smartTv.volume);


        smartTv.mudarCanalAumentar();
        smartTv.mudarCanalAumentar();
        smartTv.mudarCanalDiminuir();
        System.out.println("Canal atual: " + smartTv.canal);

    }
}

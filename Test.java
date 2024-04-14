public class Test{
    public static void main(String[] args) {
        Scatola box = new Scatola();
        Produttore azienda = new Produttore(box);
        Consumatore cliente1 = new Consumatore(box, 1, 5, "cliente-1");
        Consumatore cliente2 = new Consumatore(box, 6, 10, "cliente-2");
        azienda.start();
        cliente1.start();
        cliente2.start();
    }
}
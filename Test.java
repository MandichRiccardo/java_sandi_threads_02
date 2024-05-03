public class Test{
    public static void main(String[] args) {
        Scatola box = new Scatola();
        Produttore azienda = new Produttore(box);
        Consumatore cliente1 = new Consumatore(box, 1, 5, "cliente-1");
        Consumatore cliente2 = new Consumatore(box, 6, 10, "cliente-2");
        azienda.start();
        cliente1.start();
        cliente2.start();
        try{
            Produttore.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("\t\t\t\t\t\tinizio a chiamare gli interrupt");
        azienda.interrupt();
        cliente1.interrupt();
        cliente2.interrupt();
        System.out.println("\t\t\t\t\t\tfinisco di chiamare gli interrupt");
        try{
            azienda.join();
            cliente1.join();
            cliente2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        box.print();
    }
}
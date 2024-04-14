public class Produttore extends Thread{
    private final Scatola box;

    public Produttore(Scatola box) {
        super("azienda");
        this.box = box;
    }

    @Override
    public void run() {
        while (!isInterrupted()){
            synchronized (box){
                if(box.isEmpty()){
                    box.setValore(new java.util.Random().nextInt(1, 11));
                    System.out.println("sono " + getName() + " e ho prodotto un valore");
                }
                box.notifyAll();
                System.out.println("sono " + getName() + " e ho notificato box");
            }
            try {
                sleep(500);
            } catch (InterruptedException ignored) {}
        }
    }
}
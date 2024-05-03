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
                    box.setEmpty(false);
                    box.setValore();
                    System.out.println("sono " + getName() + " e ho prodotto un valore");
                }
                box.notifyAll();
            }
            try{
                box.wait();
            }catch(InterruptedException e){
                interrupt();
            }
            try {
                sleep(500);
            } catch (InterruptedException ignored) {}
        }
    }
}
public class Produttore extends Thread{
    private Scatola box;

    public Produttore(Scatola box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (!isInterrupted()){
            synchronized (box){
                if(box.isEmpty()){
                    box.setValore(new java.util.Random().nextInt(1, 11));
                }
                box.notifyAll();
            }
        }
    }
}
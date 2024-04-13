public class Consumatore extends Thread{
    private Scatola box;
    private int inizioIntervallo;
    private int fineIntervallo;

    public Consumatore(Scatola box, int inizioIntervallo, int fineIntervallo) {
        this.box = box;
        this.inizioIntervallo = inizioIntervallo;
        this.fineIntervallo = fineIntervallo;
    }

    public Consumatore(Scatola box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (!isInterrupted()){
            synchronized (box){
                if (!box.isEmpty()) {
                    try{
                        if(box.getValore()>=inizioIntervallo && box.getValore()<=fineIntervallo) box.setEmpty(true);
                        box.notifyAll();
                        try {
                            box.wait();
                        } catch (InterruptedException e) {
                            interrupt();
                        }
                    }catch (BoxIsEmptyException ignore){}
                }
            }
        }
    }
}

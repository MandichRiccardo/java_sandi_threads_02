public class Consumatore extends Thread{
    private final Scatola box;
    private int inizioIntervallo;
    private int fineIntervallo;

    public Consumatore(Scatola box, int inizioIntervallo, int fineIntervallo, String nome) {
        super(nome);
        this.box = box;
        this.inizioIntervallo = inizioIntervallo;
        this.fineIntervallo = fineIntervallo;
    }

    @Override
    public void run() {
        while (!isInterrupted()){
            synchronized (box){
                if (!box.isEmpty()) {
                    try{
                        if(box.getValore()>=inizioIntervallo && box.getValore()<=fineIntervallo) box.setEmpty(true);
                        System.out.println("sono " + getName() + " e ho preso un valore");
                        box.notifyAll();
                        System.out.println("sono " + getName() + " e ho notificato box");
                        try {
                            box.wait();
                            System.out.println("sono " + getName() + " e ho messo box in attesa");
                        } catch (InterruptedException e) {
                            interrupt();
                            System.out.println("sono " + getName() + " e ho chiamato interrupt()");
                        }
                    }catch (BoxIsEmptyException ignore){}
                }
            }
            try {
                sleep(500);
            } catch (InterruptedException ignored) {}
        }
    }
}

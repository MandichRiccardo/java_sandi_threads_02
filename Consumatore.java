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
                        if(box.getValore()>=inizioIntervallo && box.getValore()<=fineIntervallo) {
                            box.setEmpty(true);
                            System.out.println("sono " + getName() + " e ho preso un valore");
                        }else{
                            System.out.println("sono " + getName() + " e non ho trovato un valore che mi interessava");
                        }
                        box.notifyAll();
                        try {
                            box.wait();
                        } catch (InterruptedException e) {
                            if(box.getValore()>=inizioIntervallo && box.getValore()<=fineIntervallo) {
                            box.setEmpty(true);
                            System.out.println("sono " + getName() + " e ho preso un valore");
                        }else{
                            System.out.println("sono " + getName() + " e non ho trovato un valore che mi interessava");
                        }
                            interrupt();
                            System.out.println("sono " + getName() + " e ho chiamato interrupt()");
                        }
                    }catch (BoxIsEmptyException ignore){}
                }
            }
        }
    }
}

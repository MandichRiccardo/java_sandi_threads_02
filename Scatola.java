public class Scatola{
    private boolean empty;
    private int valore;
/*
    public Scatola(){
        setEmpty(true);
    }
*/
    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void setValore() {
        setEmpty(false);
        this.valore = new java.util.Random().nextInt(1, 11);
        System.out.println("valore impostato ora:" + this.valore);
    }

    public int getValore() throws BoxIsEmptyException {
        if(!empty) return valore;
        else throw new BoxIsEmptyException();
    }

    public void print(){
        System.out.println("empty:\t" + empty + "\nvalore:\t" + valore);
    }
}
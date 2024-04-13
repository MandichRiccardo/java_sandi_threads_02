public class Scatola{
    private boolean empty;
    private int valore;

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void setValore(int valore) {
        setEmpty(false);
        this.valore = valore;
    }

    public int getValore() throws BoxIsEmptyException {
        if(!empty) return valore;
        else throw new BoxIsEmptyException();
    }
}
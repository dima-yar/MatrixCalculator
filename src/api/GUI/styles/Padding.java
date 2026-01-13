package api.GUI.styles;

public class Padding {
    private int x;
    private int y;

    public Padding(int x,int y){
        this.x = x;
        this.y = y;
    }
    public Padding(int x){
        this.x = x;
        this.y = x;
    }

    public int X() {
        return x;
    }
    public int Y() {
        return y;
    }

}

package api.GUI.styles;

public class Margin {
    private int x;
    private int y;

    public Margin(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Margin(int x){
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

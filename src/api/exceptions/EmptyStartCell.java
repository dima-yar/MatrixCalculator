package api.exceptions;

public class EmptyStartCell extends Exception {
    public EmptyStartCell() {
        super("Start cell is empty");
    }
    public EmptyStartCell(String message) {
        super(message);
    }
}

public class MyArrayDataException extends NumberFormatException {
    private int mistakeRow;
    private int mistakeCol;

    public MyArrayDataException(int mistakeRow, int mistakeCol, String s) {
        super("The error at -> " + "arr" + "[" + mistakeRow + "]" + "[" + mistakeCol + "]. " + "Expected int but got string -> " + s);
        this.mistakeRow = mistakeRow;
        this.mistakeCol = mistakeCol;
    }

    public MyArrayDataException() {
    }

    public int getMistakeRow() {
        return mistakeRow;
    }

    public void setMistakeRow(int mistakeRow) {
        this.mistakeRow = mistakeRow;
    }

    public int getMistakeCol() {
        return mistakeCol;
    }

    public void setMistakeCol(int mistakeCol) {
        this.mistakeCol = mistakeCol;
    }
}

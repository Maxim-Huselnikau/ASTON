public class ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException {
    private int mistakeRow;
    private int mistakeCol;

    public ArrayIndexOutOfBoundsException(int mistakeRow, int mistakeCol) {
        super("The error was caught at index out of bounds- " + "[" + mistakeRow + "]" + "[" + mistakeCol + "]");
        this.mistakeRow = mistakeRow;
        this.mistakeCol = mistakeCol;
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

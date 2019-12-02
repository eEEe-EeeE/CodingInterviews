package question4.beans;

public class Result {
    private Boolean found;
    private Integer row;
    private Integer col;

    public Result(Boolean found, Integer row, Integer col) {
        this.found = found;
        this.row = row;
        this.col = col;
    }

    public Boolean getFound() {
        return found;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return col;
    }
}

package question3.beans;

public class Result {
    private Boolean found;
    private Integer dupNum;

    public Result(Boolean found, Integer dupNum) {
        this.found = found;
        this.dupNum = dupNum;
    }

    public Boolean getFound() {
        return found;
    }

    public Integer getDupNum() {
        return dupNum;
    }
}

package StringMatch;

public class MyPattern {
    private String P;
    private int[] preFix;

    public MyPattern(String p) {
        P = p;
        preFix = new int[P.length()];
    }

    public String getPatStr() {
        return P;
    }

    public void setPatStr(String p) {
        P = p;
    }

    public int getPreFixFunc(int q) {
        if (q > 0 && q <= preFix.length)
            return preFix[q - 1];
        else
            return -1;
    }

    public void setPreFixFunc(int q, int k) {
        if (0 <= k && k < q && q <= preFix.length)
            this.preFix[q] = k;
        else
            System.out.println("error: 0 <= k < q <= P.length.");
    }
}

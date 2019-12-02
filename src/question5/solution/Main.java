package question5.solution;

import question5.beans.Result;

public class Main {
    public static void main(String[] args) {
        SpaceReplacer spaceReplacer = new SpaceReplacer();
        Result r = spaceReplacer.replaceSpace("we are.", "%20");
        System.out.println(r.getS());
    }
}

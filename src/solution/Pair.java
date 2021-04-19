package solution;

import java.util.Objects;

public class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (obj == this)
            return true;
        return ((Pair) obj).x == this.x && ((Pair) obj).y == this.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    Pair emptyX() {
        return new Pair(0, y);
    }
    Pair emptyY() {
        return new Pair(x, 0);
    }

    Pair fullX(int val) {
        return new Pair(val, y);
    }
    Pair fullY(int val) {
        return new Pair(x, val);
    }
    Pair xToy(int capacityY) {
        int delta = Math.min(x, capacityY - y);
        return new Pair(x - delta, y + delta);
    }
    Pair yTox(int capacityX) {
        int delta = Math.min(y, capacityX - x);
        return new Pair(x + delta, y - delta);
    }

}

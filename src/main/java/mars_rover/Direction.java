package mars_rover;

public enum Direction {
    N("N"),
    S("S"),
    E("E"),
    W ("W");

    private final String shortAlias;

    Direction(String shortAlias) {
        this.shortAlias = shortAlias;
    }

    public String getAlias() {
        return this.shortAlias;
    }
}

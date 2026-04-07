package mars_rover;

public enum Direction {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST ("W");

    private final String shortAlias;

    Direction(String shortAlias) {
        this.shortAlias = shortAlias;
    }

    public String getAlias() {
        return this.shortAlias;
    }
}

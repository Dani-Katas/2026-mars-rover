package mars_rover;

import java.util.Optional;

public enum Command {
    BACKWARD,
    FORWARD,
    LEFT,
    RIGHT;

    public static Optional<Command> parse(String command) {
        switch (command) {
            case "b":
                return Optional.of(Command.BACKWARD);
            case "f":
                return Optional.of(Command.FORWARD);
            case "l":
                return Optional.of(Command.LEFT);
            case "r":
                return Optional.of(Command.RIGHT);
        }
        return Optional.empty();
    }

    boolean isRotation() {
      return equals(LEFT) || equals(RIGHT);
    }

    Direction rotate(Direction direction) {
      return equals(RIGHT) ? direction.rotateRight() : direction.rotateLeft();
    }
}

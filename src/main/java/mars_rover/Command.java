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

    Coordinates displaceIn(Direction direction, Coordinates coordinates) {
      if(equals(FORWARD)) {
        int displacement;
        if (direction.isPositiveAxis()) {
          displacement = 1;
        } else {
          displacement = -1;
        }
        if (direction.isVertical()) {
          return coordinates.displaceInYDirection(displacement);
        } else {
          return coordinates.displaceInXDirection(displacement);
        }
      } else {
        int displacement;
        if (direction.isPositiveAxis()) {
          displacement = -1;
        } else {
          displacement = 1;
        }
        if (direction.isVertical()) {
          return coordinates.displaceInYDirection(displacement);
        } else {
          return coordinates.displaceInXDirection(displacement);
        }
      }

    }
}

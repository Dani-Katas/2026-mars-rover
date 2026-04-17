package mars_rover;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Rover {

  private Coordinates coordinates;

  private Direction direction;

  public Rover(int x, int y, String direction) {
    this.direction = Direction.valueOf(direction);
    this.coordinates = new Coordinates(x, y);
  }

  public void receive(String commandsSequence) {
      parse(commandsSequence).forEach(this::process);
  }

  private static Stream<Command> parse(String commandsSequence) {
    return Arrays.stream(commandsSequence.split("")).map(Command::parse).flatMap(Optional::stream);
  }

  private void process(Command command) {
    if (command.isRotation()) {
      direction = command.rotate(direction);
    } else {
      this.coordinates = displaceRover2(command, direction, this.coordinates);
    }
  }

  private Coordinates displaceRover2(Command command, Direction direction, Coordinates coordinates) {
    if(command.equals(Command.FORWARD)) {
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

  @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(coordinates, rover.coordinates) && Objects.equals(direction, rover.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, direction);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "coordinates=" + coordinates +
                ", direction='" + direction + '\'' +
                '}';
    }
}

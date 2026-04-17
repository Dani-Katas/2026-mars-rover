package mars_rover;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

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
      rotateRover(command);
    } else {
      displaceRover(command);
    }
  }

  private void displaceRover(Command command) {
    int displacement = command.equals(Command.FORWARD) ? 1 : -1;

      if (direction.equals(Direction.N)) {
      this.coordinates = this.coordinates.displaceInYDirection(displacement);
    } else if (direction.equals(Direction.S)) {
      this.coordinates = this.coordinates.displaceInYDirection(-displacement);
    } else if (direction.equals(Direction.W)) {
      this.coordinates = coordinates.displaceInXDirection(-displacement);
    } else {
        this.coordinates = coordinates.displaceInXDirection(displacement);

    }
  }

  private void rotateRover(Command command) {
      direction = command.equals(Command.RIGHT) ? direction.rotateRight() : direction.rotateLeft();
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

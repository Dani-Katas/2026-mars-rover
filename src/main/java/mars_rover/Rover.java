package mars_rover;

import java.util.Objects;

public class Rover {

  private Direction direction;

  private Coordinates coordinates;

  public Rover(int x, int y, String direction) {
    this.direction = Direction.valueOf(direction);
    this.coordinates = new Coordinates(x, y);
  }

  public void receive(String commandsSequence) {
    for (int i = 0; i < commandsSequence.length(); ++i) {
      String command = commandsSequence.substring(i, i + 1);
      process(command);
    }
  }

  private void process(final String command) {
    if (command.equals("l")) {
      this.direction = direction.rotateLeft();
    } else if (command.equals("r")) {
      this.direction = direction.rotateRight();
    } else if (command.equals("f")) {
      this.coordinates = direction.move(this.coordinates, 1);
    } else if (command.equals("b")) {
      this.coordinates = direction.move(this.coordinates, -1);
    }
  }

  @Override
  public String toString() {
    return "Rover{" +
        "coordinates=" + coordinates +
        ", direction=" + direction +
        '}';
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Rover rover = (Rover) o;
    return direction == rover.direction && Objects.equals(coordinates, rover.coordinates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(direction, coordinates);
  }
}

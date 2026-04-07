package mars_rover;

import java.util.Objects;

public class Rover {

  private Coordinates coordinates;

  private Direction direction;

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

  private void process(String command) {
    if (command.equals("l") || command.equals("r")) {
      rotateRover(command);
    } else {
      displaceRover(command);
    }
  }

  private void displaceRover(String command) {
    int displacement = command.equals("f") ? 1 : -1;

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

  private void rotateRover(String command) {
    if (command.equals("r")) direction = direction.rotateRight();
    else direction = direction.rotateLeft();
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

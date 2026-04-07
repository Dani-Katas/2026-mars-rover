package mars_rover;

import java.util.Objects;

public class Rover {

  private Coordinates coordinates;

  private Direction direction2;

  public Rover(int x, int y, String direction) {
    this.direction2 = Direction.valueOf(direction);
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

      if (direction2.equals(Direction.N)) {
      this.coordinates = this.coordinates.displaceInYDirection(displacement);
    } else if (direction2.equals(Direction.S)) {
      this.coordinates = this.coordinates.displaceInYDirection(-displacement);
    } else if (direction2.equals(Direction.W)) {
      this.coordinates = coordinates.displaceInXDirection(-displacement);
    } else {
        this.coordinates = coordinates.displaceInXDirection(displacement);

    }
  }

    private void rotateRover(String command) {
    if (direction2.equals(Direction.N)) {
      if (command.equals("r")) {
        direction2 = Direction.E;
      } else {
        direction2 = Direction.W;
      }
    } else if (direction2.equals(Direction.S)) {
      if (command.equals("r")) {
        direction2 = Direction.W;
      } else {
        direction2 = Direction.E;
      }
    } else if (direction2.equals(Direction.W)) {
      if (command.equals("r")) {
        direction2 = Direction.N;
      } else {
        direction2 = Direction.S;
      }
    } else {
      if (command.equals("r")) {
        direction2 = Direction.S;
      } else {
        direction2 = Direction.N;
      }
    }
  }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(coordinates, rover.coordinates) && Objects.equals(direction2, rover.direction2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, direction2);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "coordinates=" + coordinates +
                ", direction='" + direction2 + '\'' +
                '}';
    }
}

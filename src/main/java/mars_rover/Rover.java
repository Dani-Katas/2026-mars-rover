package mars_rover;

import java.util.Objects;

public class Rover {

  private Coordinates coordinates;

  private String direction;

  public Rover(int x, int y, String direction) {
    this.direction = direction;
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

      if (direction.equals("N")) {
      this.coordinates = this.coordinates.displaceInYDirection(displacement);
    } else if (direction.equals("S")) {
      this.coordinates = this.coordinates.displaceInYDirection(-displacement);
    } else if (direction.equals("W")) {
      this.coordinates = coordinates.displaceInXDirection(-displacement);
    } else {
        this.coordinates = coordinates.displaceInXDirection(displacement);

    }
  }

    private void rotateRover(String command) {
    if (direction.equals("N")) {
      if (command.equals("r")) {
        direction = "E";
      } else {
        direction = "W";
      }
    } else if (direction.equals("S")) {
      if (command.equals("r")) {
        direction = "W";
      } else {
        direction = "E";
      }
    } else if (direction.equals("W")) {
      if (command.equals("r")) {
        direction = "N";
      } else {
        direction = "S";
      }
    } else {
      if (command.equals("r")) {
        direction = "S";
      } else {
        direction = "N";
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

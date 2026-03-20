package mars_rover;

public class Rover {

  private final Coordinates coordinates;
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
    int displacement1 = -1;

    if (command.equals("f")) {
        displacement1 = 1;
    }
    int displacement = displacement1;

    if (direction.equals("N")) {
        this.coordinates.setY(this.coordinates.getY() + displacement);
    } else if (direction.equals("S")) {
        this.coordinates.setY(this.coordinates.getY() - displacement);
    } else if (direction.equals("W")) {
        this.coordinates.setX(this.coordinates.getX() - displacement);
    } else {
        this.coordinates.setX(this.coordinates.getX() + displacement);
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

      if (this.coordinates.getY() != rover.coordinates.getY()) return false;
      if (this.coordinates.getX() != rover.coordinates.getX()) return false;
        return direction != null ? direction.equals(rover.direction) : rover.direction == null;

    }

    @Override
    public int hashCode() {
        int result = direction != null ? direction.hashCode() : 0;
        result = 31 * result + this.coordinates.getY();
        result = 31 * result + this.coordinates.getX();
        return result;
    }

    @Override
    public String toString() {
        return "Rover{" +
            "direction='" + direction + '\'' +
            ", y=" + this.coordinates.getY() +
            ", x=" + this.coordinates.getX() +
            '}';
    }

}

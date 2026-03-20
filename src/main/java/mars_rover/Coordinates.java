package mars_rover;

import java.util.Objects;

public class Coordinates {

  private final int x;

  private final int y;

  public Coordinates(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  Coordinates moveAlongXAxis(final int displacement) {
    return new Coordinates(this.x - displacement, this.y);
  }

  Coordinates moveAlongYAxis(final int displacement) {
    return new Coordinates(this.x, this.y + displacement);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Coordinates that = (Coordinates) o;
    return x == that.x && y == that.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return "Coordinates{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}

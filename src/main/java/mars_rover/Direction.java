package mars_rover;

public enum Direction {
  N {
    @Override
    Coordinates move(final Coordinates coordinates, final int displacement) {
      return coordinates.moveAlongYAxis(displacement);
    }

    @Override
    Direction rotateLeft() {
      return W;
    }

    @Override
    Direction rotateRight() {
      return E;
    }
  },
  S {
    @Override
    Coordinates move(final Coordinates coordinates, final int displacement) {
      return coordinates.moveAlongYAxis(-displacement);
    }

    @Override
    Direction rotateLeft() {
      return E;
    }

    @Override
    Direction rotateRight() {
      return W;
    }
  },
  E {
    @Override
    Coordinates move(final Coordinates coordinates, final int displacement) {
      return coordinates.moveAlongXAxis(-displacement);
    }

    @Override
    Direction rotateLeft() {
      return N;
    }

    @Override
    Direction rotateRight() {
      return S;
    }
  },
  W {
    @Override
    Coordinates move(final Coordinates coordinates, final int displacement) {
      return coordinates.moveAlongXAxis(displacement);
    }

    @Override
    Direction rotateLeft() {
      return S;
    }

    @Override
    Direction rotateRight() {
      return N;
    }
  };

  abstract Direction rotateRight();

  abstract Direction rotateLeft();

  abstract Coordinates move(final Coordinates coordinates, final int displacement);
}

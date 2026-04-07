package mars_rover;

public enum Direction {
    N {
        @Override
        public Direction rotateRight() {
            return Direction.E;
        }

        @Override
        public Direction rotateLeft() {

            return Direction.W;
        }
    },
    S {
        @Override
        public Direction rotateRight() {

            return Direction.W;
        }

        @Override
        public Direction rotateLeft() {

            return Direction.E;
        }
    },
    E {
        @Override
        public Direction rotateRight() {

            return Direction.S;
        }

        @Override
        public Direction rotateLeft() {

            return Direction.N;
        }
    },
    W {
        @Override
        public Direction rotateRight() {

            return Direction.N;
        }

        @Override
        public Direction rotateLeft() {

            return Direction.S;
        }
    };

    abstract public Direction rotateRight();
    abstract public Direction rotateLeft();
}

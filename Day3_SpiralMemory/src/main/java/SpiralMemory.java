import java.awt.*;

public class SpiralMemory {

    private enum Direction {NORTH, SOUTH, EAST, WEST}

    /**
     * You come across an experimental new kind of memory stored on an infinite two-dimensional grid.
     * <p>
     * Each square on the grid is allocated in a spiral pattern starting at a location marked 1 and then counting up while spiraling outward. For
     * example, the first few squares are allocated like this:
     * <p>
     * 17  16  15  14  13<br/>
     * 18   5   4   3  12<br/>
     * 19   6   1   2  11<br/>
     * 20   7   8   9  10<br/>
     * 21  22  23---> ...<br/>
     * While this is very space-efficient (no squares are skipped), requested data must be carried back to square 1 (the location of the only
     * access port for this memory system) by programs that can only move up, down, left, or right. They always take the shortest path: the
     * Manhattan Distance between the location of the data and square 1.
     * <p>
     * For example:
     * <p>
     * Data from square 1 is carried 0 steps, since it's at the access port.
     * Data from square 12 is carried 3 steps, such as: down, left, left.
     * Data from square 23 is carried only 2 steps: up twice.
     * Data from square 1024 must be carried 31 steps.
     */
    public int calculateDistanceToPort(int finalNumber) {
        final int[][] grid = createGrid(finalNumber);
        final Point port = new Point((int) Math.ceil(grid.length / 2.0) - 1, (int) Math.floor(grid.length / 2.0));
        final Point finalPoint = populateGrid(grid, finalNumber, port);
        return Math.abs(finalPoint.x - port.x) + Math.abs(finalPoint.y - port.y);
    }

    private int[][] createGrid(int finalNumber) {
        int gridSize = (int) Math.ceil(Math.sqrt(finalNumber));
        return new int[gridSize][gridSize];
    }

    private Point populateGrid(int[][] grid, int finalNumber, Point port) {
        Direction direction = Direction.SOUTH;
        final Point currentPosition = new Point(port.x, port.y);
        grid[port.y][port.x] = 1;
        for (int num = 2; num <= finalNumber; num++) {
            direction = populateNextPosition(grid, direction, num, currentPosition);
        }
        return currentPosition;
    }

    private Direction populateNextPosition(int[][] grid, Direction direction, int num, Point currentPosition) {
        switch (direction) {
            case NORTH:
                if (grid[currentPosition.y][currentPosition.x - 1] == 0) {
                    return goWest(grid, num, currentPosition);
                } else {
                    return goNorth(grid, num, currentPosition);
                }
            case SOUTH:
                if (grid[currentPosition.y][currentPosition.x + 1] == 0) {
                    return goEast(grid, num, currentPosition);
                } else {
                    return goSouth(grid, num, currentPosition);
                }
            case EAST:
                if (grid[currentPosition.y - 1][currentPosition.x] == 0) {
                    return goNorth(grid, num, currentPosition);
                } else {
                    return goEast(grid, num, currentPosition);
                }
            case WEST:
                if (grid[currentPosition.y + 1][currentPosition.x] == 0) {
                    return goSouth(grid, num, currentPosition);
                } else {
                    return goWest(grid, num, currentPosition);
                }
        }
        throw new RuntimeException("Unexpected direction: " + direction);
    }

    private Direction goSouth(final int[][] grid, final int num, final Point currentPosition) {
        grid[currentPosition.y + 1][currentPosition.x] = num;
        currentPosition.y = currentPosition.y + 1;
        return Direction.SOUTH;
    }

    private Direction goEast(final int[][] grid, final int num, final Point currentPosition) {
        grid[currentPosition.y][currentPosition.x + 1] = num;
        currentPosition.x = currentPosition.x + 1;
        return Direction.EAST;
    }

    private Direction goNorth(final int[][] grid, final int num, final Point currentPosition) {
        grid[currentPosition.y - 1][currentPosition.x] = num;
        currentPosition.y = currentPosition.y - 1;
        return Direction.NORTH;
    }

    private Direction goWest(final int[][] grid, final int num, final Point currentPosition) {
        grid[currentPosition.y][currentPosition.x - 1] = num;
        currentPosition.x = currentPosition.x - 1;
        return Direction.WEST;
    }
}


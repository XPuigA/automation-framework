package automation_practice.pathfinding;

import java.util.List;

public interface PathFinder {

    List<Position> findPath(Position start, Position end, int rows, int columns, char[][] map);
}

package pathfinding;

import java.util.*;

public class BFS implements PathFinder {

    private static final int[] ROW_DIRECTION = {0, 1, -1 , 0};
    private static final int[] COLUMN_DIRECTION = {1, 0, 0, -1};

    @Override
    public List<Position> findPath(Position start, Position end, int rows, int columns, char[][] map) {
        Deque<Position> q = new ArrayDeque<>();
        Position[][] visited = new Position[rows][columns];

        q.addLast(start);
        visited[0][0] = start;

        while(!q.isEmpty()) {
            Position current = q.removeFirst();
            if (current.equals(end)) {
                return reversePath(start, end, visited);
            }
            else {
                for (int i = 0; i < 4; ++i) {
                    Position newPosition = new Position(current.row + ROW_DIRECTION[i], current.column + COLUMN_DIRECTION[i]);
                    if (isValidPosition(newPosition, rows, columns) && visited[newPosition.row][newPosition.column] == null && isNotBlocked(newPosition, map)) {
                        q.addLast(newPosition);
                        visited[newPosition.row][newPosition.column] = current;
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    private List<Position> reversePath(Position start, Position end, Position[][] visited) {
        LinkedList<Position> path = new LinkedList<>();
        path.addFirst(end);
        Position next = visited[end.row][end.column];
        while (next != start) {
            path.addFirst(next);
            next = visited[next.row][next.column];
        }
        return path;
    }

    private boolean isValidPosition(Position position, int rows, int columns) {
        return position.row >= 0 && position.row < rows && position.column >= 0 && position.column < columns;
    }

    private boolean isNotBlocked(Position position, char[][] map) {
        return map[position.row][position.column] != 'X';
    }
}

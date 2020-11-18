package pages.levels;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.WebPage;
import pathfinding.BFS;
import pathfinding.Position;

import java.util.*;
import java.util.stream.Collectors;

public class Level16Page extends WebPage {

    public Level16Page(Driver driver) {
        super(driver);
    }

    public int getNumberOfRows() {
        return Integer.parseInt(getLabyrinthElement().getAttribute("data-rows"));
    }

    public int getNumberOfColumns() {
        return Integer.parseInt(getLabyrinthElement().getAttribute("data-columns"));
    }

    public void findPath() {
        int rows = getNumberOfRows();
        int columns = getNumberOfColumns();

        Position start =  new Position(0, 0);
        Position end = new Position(rows - 1, columns - 1);

        char[][] map = labyrinthAsArray(rows, columns);
        clickPath(new BFS().findPath(start, end, rows, columns, map));
    }

    private WebElement getLabyrinthElement() {
        return driver.findElement(".labyrinth");
    }

    private void clickPath(List<Position> path) {
        for (Position position : path) {
            driver.click(".cell-button[data-row=\"" + position.row + "\"][data-column=\"" + position.column + "\"]");
        }
    }

    private char[][] labyrinthAsArray(int rows, int columns) {
        char[][] map = new char[rows][columns];

        for (int row = 0; row < rows; ++row) {
            for (int column = 0; column < columns; ++column) {
                String cell = driver.findElement(".cell-button[data-row=\"" + row + "\"][data-column=\"" + column + "\"]").getAttribute("class");
                map[row][column] = cell.contains("blocked") ? 'X' : ' ';
            }
        }
        return map;
    }
}

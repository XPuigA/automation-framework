package pages.levels;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.WebPage;

import java.util.List;
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

    private WebElement getLabyrinthElement() {
        return driver.findElement(".labyrinth");
    }

    public void findPath() {
        int rows = getNumberOfRows();
        int columns = getNumberOfColumns();

        int startRow = 0; int startColumn = 0;
        int endRow = rows - 1; int endColumn = columns - 1;

        char[][] map = labyrinthAsArray(rows, columns);

    }

    private char[][] labyrinthAsArray(int rows, int columns) {
        char[][] map = new char[rows][columns];

        for (int row = 0; row < rows; ++row) {
            for (int column = 0; column < columns; ++column) {
                String cell = driver.findElement(".cell-button[data-row=\"" + row + "\"][data-column=\"" + column + "\"]").getAttribute("class");
                map[row][column] = cell.contains("blocked") ? 'X' : ' ';
                System.out.print(map[row][column]);
            }
            System.out.println();
        }

        return map;
    }
}

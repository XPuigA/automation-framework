package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level16Page;

@Execution(ExecutionMode.CONCURRENT)
class Level16Tests extends ManagedDriverUITest {

    @Test
    void correctTest() {
        goTo(url + "level16");
        Level16Page page = new Level16Page(driver);
        page.findPath();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level17"));
    }


}

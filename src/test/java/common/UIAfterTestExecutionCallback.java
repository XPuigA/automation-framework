package common;

import driver.Driver;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import reports.AllureAttachment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class UIAfterTestExecutionCallback implements AfterTestExecutionCallback {

    protected static final Logger LOGGER = Logger.getLogger("MainLogger");

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        Driver driver = ((ManagedDriverUITest) extensionContext.getTestInstance().get()).getDriver();
        String testName = "";
        if (extensionContext.getTestMethod().isPresent()) {
            testName = extensionContext.getTestMethod().get().getName();
        }
        if(extensionContext.getExecutionException().isPresent()) { // Test failed
            // Process screenshot
            String screenshotPath = driver.screenShot(testName);
            this.attachScreenshotToReport(screenshotPath);

            // Process HTML
            String htmlPath = driver.saveHtml(testName);
            this.attachHtmlToReport(htmlPath);

            this.attachJavascriptConsoleContents(driver);

            this.attachUrl(driver);
        }
    }

    // Allure report functions
    private void attachScreenshotToReport(String screenshotPath) {
        this.attachFile(screenshotPath);
    }

    private void attachHtmlToReport(String htmlPath) {
        this.attachFile(htmlPath);
    }

    private void attachJavascriptConsoleContents(Driver driver) {
        LogEntries logs = driver.getWebDriver().manage().logs().get(LogType.BROWSER);
        StringBuilder sb = new StringBuilder();
        for (LogEntry log : logs) {
            sb.append(log.getMessage()).append("\n");
        }

        String logContent = sb.toString();
        if (!logContent.isEmpty()) {
            AllureAttachment.add("Console log", sb.toString());
        }
    }

    private void attachUrl(Driver driver) {
        AllureAttachment.add("Current URL", driver.getCurrentUrl());
    }

    private void attachFile(String path) {
        File file = new File(path);
        Path content = Paths.get(path);
        try (InputStream is = Files.newInputStream(content)) {
            AllureAttachment.add(file.getName(), is);
        } catch (IOException ex) {
            LOGGER.warning("Could not read: " + path);
        }
    }
}

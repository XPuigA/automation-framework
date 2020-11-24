package reports;

import io.qameta.allure.Allure;

import java.io.InputStream;

public interface Attachment {

    /**
     * Adds a content into a report
     * @param name name of the content
     * @param content the content itself
     */
    void add(String name, String content);

    /**
     * Adds a content into a report
     * @param name name of the content
     * @param stream the content itself
     */
    void add(String name, InputStream stream);
}

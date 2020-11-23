package reports;

import io.qameta.allure.Allure;

import java.io.InputStream;

public interface Attachment {
    void add(String name, String content);

    void add(String name, InputStream stream);
}

package reports;

import io.qameta.allure.Allure;

import java.io.InputStream;

public class AllureAttachment implements Attachment {

    public AllureAttachment() {}

    public void add(String name, String content) {
        Allure.addAttachment(name, content);
    }

    public void add(String name, InputStream stream) {
        Allure.addAttachment(name, stream);
    }
}

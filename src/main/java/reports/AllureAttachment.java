package reports;

import io.qameta.allure.Allure;

import java.io.InputStream;

public class AllureAttachment implements Attachment {

    private AllureAttachment() {}

    public static void add(String name, String content) {
        Allure.addAttachment(name, content);
    }

    public static void add(String name, InputStream stream) {
        Allure.addAttachment(name, stream);
    }
}

package reports;

public class AttachmentSingleton {

    private static Attachment instance;

    public static Attachment getInstance() {
        if (instance == null) {
            instance = newInstance();
        }
        return instance;
    }

    private static Attachment newInstance() {
        switch(System.getProperty("reporter")) {
            default:
                return new AllureAttachment();
        }
    }
}

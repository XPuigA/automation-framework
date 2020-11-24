package common;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

/**
 * If we want to make some special operation when the test finishes with a specific state.
 */
public class UITestWatcher implements TestWatcher {

    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable) {

    }

    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {

    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {

    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {

    }
}

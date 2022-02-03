package assertions;

import model.Status;
import org.bouncycastle.util.Objects;
import pages.LoginPage;

import static io.vavr.Predicates.isNotNull;

public class LoginPageAssert extends AbstractAssert<LoginPageAssert, LoginPage> {

    private static final String ERROR_MESSAGE_TEMPLATE = "Error:";

    public LoginPageAssert(final LoginPage loginPage) {
        super(loginPage, LoginPageAssert.class);
    }

    public LoginPageAssert hasLoginStatus(final Status status) {
        isNotNull();

        final String loginStatus = actual.getLoginStatus();
        final String expectedLoginStatus = status.getName();

        if (!Objects.areEqual(loginStatus, expectedLoginStatus)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Status name", actual, expectedLoginStatus, loginStatus);
        }
        return this;
    }

}

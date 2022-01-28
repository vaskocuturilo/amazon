package core;

import static org.joor.Reflect.onClass;

public class PageFactory {

    public static <T extends Page> T open(final Class<T> pageClass) {
        return (T) at(pageClass).navigateTo();
    }

    public static <T extends Page> T at(final Class<T> pageClass) {
        return onClass(pageClass).create().get();
    }
}

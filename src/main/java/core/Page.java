package core;

public interface Page {

    default Page navigateTo() {
        return navigateTo(url());
    }

    Page navigateTo(String url);

    default String url() {
        return url();
    }
}

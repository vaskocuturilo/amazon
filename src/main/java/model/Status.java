package model;

public enum Status {

    LOGIN_SUCCESSFUL("Authorized successfully"),
    LOGIN_FAILED("Cannot find an account with such credentials");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package model;

public enum Category {

    BRAND("Brand"),
    SELLER("Seller"),
    COLOR("Color");

    private String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

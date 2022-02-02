package model;

public enum SortItems {

    PRICE_LOW_TO_HIGH("Price: Low to High"),
    PRICE_HIGH_TO_LOW("Price: High to Low"),
    DISCOUNT_LOW_TO_HIGH("Discount: Low to High"),
    DISCOUNT_HIGH_TO_LOW("Discount: High to Low");

    private final String name;

    SortItems(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package model;

import lombok.Data;

@Data
public class Items extends Product {

    private String size;
    private String color;
    private String brand;
    private String price;

    public Items(String name, String category) {
        super(name, category);
    }


}

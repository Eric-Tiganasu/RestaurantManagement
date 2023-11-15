package org.eric.dto;

import lombok.ToString;

@ToString
public class Combo {
    private static int nextId = 1;
    private static final int MAX_DISH_NUM = 20;
    private static final int MAX_BEVERAGE_NUM = 20;
    private String name;
    private String id;
    private double price;
    private Beverage[] beverages;
    private Dish[] dishes;

    public Combo(String name) {
        this.id = String.format("C%03d", nextId++);
        this.name = name;
        this.dishes = new Dish[MAX_DISH_NUM];
        this.beverages = new Beverage[MAX_BEVERAGE_NUM];
    }

    public void addDish(Dish dish) {
        if (dishes[0] == null) {
            dishes[0] = dish;
            calcPrice();
        } else if (dishes[1] == null) {
            dishes[1] = dish;
            calcPrice();
        } else {
            System.out.printf("There are already %d dishes, add dishes failed.", MAX_DISH_NUM);
        }
    }

    public void addBeverage(Beverage beverage) {
        if (beverages[0] == null) {
            beverages[0] = beverage;
            calcPrice();
        } else if (beverages[1] == null) {
            beverages[1] = beverage;
            calcPrice();
        } else {
            System.out.printf("There are already %d dishes, add dishes failed.", MAX_BEVERAGE_NUM);
        }
    }

    public void calcPrice() {
        double price = 0;

        for (Beverage beverage : beverages) {
            if (beverage != null) {
                price += beverage.getPrice();
            }
        }

        for (Dish dish : dishes) {
            if (dish != null) {
                price += dish.getPrice();
            }
        }

        double discountRatio = 0.8;
        this.price = price * discountRatio;
    }
}

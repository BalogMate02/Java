import java.awt.*;

public abstract class PizzaIngredient implements Pizza {
    private Pizza pizza;
    public PizzaIngredient(Pizza p){
        this.pizza=p;
    }

    @Override
    public void bake(Graphics g) {
        pizza.bake(g);
    }

    @Override
    public int getprice() {
        return pizza.getprice();
    }

    @Override
    public String getingredients() {
        return pizza.getingredients();
    }
}

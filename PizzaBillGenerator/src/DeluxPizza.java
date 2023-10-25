public class DeluxPizza extends Pizza {
    @Override
    public void addExtraCheese() {}

    @Override
    public void addExtraToppings() {}

    @Override
    public void takeAway() {}

    public DeluxPizza(Boolean vegan) {
        super(vegan);
        super.addExtraCheese();
        super.addExtraToppings();

    }
}

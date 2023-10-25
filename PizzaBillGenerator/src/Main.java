public class Main {
    public static void main(String[] args) {
        DeluxPizza dp = new DeluxPizza(false);
        dp.addExtraCheese();
        dp.addExtraToppings();
        dp.getBill();
    }
}
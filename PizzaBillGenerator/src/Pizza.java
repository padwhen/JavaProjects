public class Pizza {
    private double price;
    private Boolean vegan;
    private double extraCheesePrice = 1.5;
    private double extraToppingPrice = 1.5;
    private double bagPrice = 0.25;
    private double veganBase = 8;
    private double nonVeganBase = 10;

    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingsAdded = false;
    private boolean isTakeAway = false;
    public Pizza(Boolean vegan) {
        this.vegan = vegan;
        if (this.vegan) {
            this.price = veganBase;
        } else {
            this.price = nonVeganBase;
        }
    }
    public void getPizzaPrice() {
        System.out.println(this.price);
    }
    public void addExtraCheese() {
        isExtraCheeseAdded = true;
        System.out.println("Extra cheese added");
        this.price += extraCheesePrice;
    }

    public void addExtraToppings() {
        isExtraToppingsAdded = true;
        System.out.println("Extra toppings added");
        this.price += extraToppingPrice;
    }

    public void takeAway() {
        isTakeAway = true;
        System.out.println("Take away opted");
        this.price += bagPrice;
    }

    public void getBill() {
        System.out.println("=== BILL ===");
        if (vegan) {
            System.out.println("Base: " + veganBase + " euros.");
        } else {
            System.out.println("Base: " + nonVeganBase + " euros.");
        }
        if (isExtraCheeseAdded) {
            System.out.println("Extra cheese added! +" + extraCheesePrice + " euros");
        }
        if (isExtraToppingsAdded) {
            System.out.println("Extra toppings added! +" + extraToppingPrice + " euros");
        }
        if (isTakeAway) {
            System.out.println("Take away +" + bagPrice + "euros");
        }
        System.out.println("Your total is: " + this.price);

    }
}

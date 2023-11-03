class Component {
    private String id;
    private String name;
    private double price;
    public Component(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setId() { this.id = id; }
    public void setName() { this.name = name; }
    public void setPrice() { this.price = price; }
}

class Frame extends Component {
    private String material;

    public Frame(String id, String name, String material, double price) {
        super(id, name, price);
        this.material = material;
    }
    public String getMaterial() { return material; }
    public void setMaterial() { this.material = material; }
    public String toString() {
        return super.getId() + ": " + super.getName() + " " + material + " frame, " + super.getPrice() + " euros";
    }
}

class GroupSet extends Component {
    private int gears;
    public GroupSet(String id, String name, int gears, double price) {
        super(id, name, price);
        this.gears = gears;
    }
    public int getGears() { return gears; }
    public void setGears() { this.gears = gears; }
    public String toString() {
        return super.getId() + ": " + super.getName() + " group set, " + gears + " gears, " + super.getPrice() + " euros";
    }
}

public class ComponentInheritanceProgram {
    public static void main(String[] args) {
        Component[] bike1 = { new Frame("F001", "SuperLight", "titanium", 1500),
                new GroupSet("GS01", "Campagnolo Record", 11, 2300) };
        Component[] bike2 = { new Frame("F002", "AluLight", "aluminium", 700),
                new GroupSet("GS02", "Shimano Ultegra", 10, 900) };
        double totalPrice = 0;
        System.out.println("--- Bike 1 ---");
        for (Component component : bike1) {
            System.out.println(component);
            totalPrice += component.getPrice();
        }
        System.out.println("Total price: " + totalPrice);
        totalPrice = 0;
        System.out.println("\n--- Bike 2 ---");
        for (Component component : bike2) {
            System.out.println(component);
            totalPrice += component.getPrice();
        }
        System.out.println("Total price: " + totalPrice);
    }
}
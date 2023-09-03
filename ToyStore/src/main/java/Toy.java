public class Toy {
    public int id;
    public String name;
    public int quantity;
    public int weight;

    public Toy(int id, String name, int quantity, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public String getInfo() {
        return "id: " + id + " игрушка: " + name;
    }
}

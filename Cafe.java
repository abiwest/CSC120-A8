/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * 
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * 
     * @param size
     * @param nSugarPackets
     * @param nCreams
     * Makes the coffee by subtracting the correct number of ingredients from inventory. Throws exception if there's not enough inventory.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (size < nCoffeeOunces && nSugarPackets < this.nSugarPackets && nCreams < this.nCreams && nCups > 0) {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("Coffee has been made!");
        } else {
            throw new RuntimeException("There is not enough stock to make this drink! Please restock!");
        }
    }

    /**
     * 
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     * Restocks cafe with the given number of items
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Cafe has been restocked :)");
    }
    
    public static void main(String[] args) {
        Cafe c = new Cafe("Compass Cafe", "Neilson Library", 2, 100, 10, 10, 10);
        c.sellCoffee(20, 2, 2);
        c.restock(20, 20, 20, 20);
    }
    
}
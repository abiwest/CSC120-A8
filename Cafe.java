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
     * Makes the coffee by subtracting the correct number of ingredients from inventory. Throws exception if there's not enough inventory.
     * @param size
     * @param nSugarPackets
     * @param nCreams
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
     * Creates a default black coffee if just given the size
     * @param size
     */
    public void sellCoffee(int size) {
        sellCoffee(size, 0,0);
    }

    /**
     * 
     * Creates default coffee with an equal amount of cream and sugar if the person doesn't specify sugar amount
     * @param size
     * @param nCreams
     */
    public void sellCoffee(int size, int nCreams) {
        sellCoffee(size, nCreams, nCreams);
    }

    /**
     * 
     * Restocks cafe with the given number of items
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Cafe has been restocked :)");
    }

    /**
     * Shows all options that the cafe can implement
     */
    public void showOptions() {
        super.showOptions();
        System.out.println(" + restock() \n + sellCoffee()");
    }

    public void goToFloor(int floorNum) {
        throw new UnsupportedOperationException("Cafe's do not have elevators, sorry.");
    }
    
    public static void main(String[] args) {
        Cafe c = new Cafe("Compass Cafe", "Neilson Library", 2, 100, 10, 10, 10);
        c.sellCoffee(20, 2, 2);
        c.restock(20, 20, 20, 20);

        c.showOptions();

    }
    
}
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        // Classrooom buildings
        Building ford = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        myMap.addBuilding(ford);
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));

        // Libraries
        Library neilson = new Library("Neilson Library","7 Neilson Drive, Northampton, MA 01063", 4, true); 
        myMap.addBuilding(neilson);
        myMap.addBuilding(new Library("Josten Library", "122 Green St, Northampton, MA 01063", 2, true));

        ArrayList<String> newTitles = new ArrayList<>();
        newTitles.add("Harry Potter 1");
        newTitles.add("Harry Potter 2");
        neilson.addTitle(newTitles);
        neilson.removeTitle(newTitles);

        // Houses
        House haynes = new House("Haynes House", "1 Mandelle Road", 4, true, true);
        myMap.addBuilding(haynes);
        myMap.addBuilding(new House("Wilson House", "1 Paradise Rd, Northampton, MA 01063"));
        myMap.addBuilding(new House("Gardiner House", "1 Paradise Rd, Northampton, MA 01063"));
        myMap.addBuilding(new House("Jordan House", "1 Paradise Rd, Northampton, MA 01063"));

        Student abi = new Student("Abi", 991123);
        Student abigail = new Student("Abigail", 991321);
        ArrayList<Student> newStudents = new ArrayList<>();
        newStudents.add(abigail);
        newStudents.add(abi);
        haynes.moveIn(newStudents);

        // Cafes
        Cafe ccCafe = new Cafe("CC Cafe", "1 Chapin Way", 1, 100, 100, 100, 100);
        Cafe compass = new Cafe("Compass Cafe", "Neilson Library", 2, 100, 10, 10, 10);
        myMap.addBuilding(ccCafe);
        myMap.addBuilding(compass);

        ccCafe.sellCoffee(10); // Just black coffee
        ccCafe.sellCoffee(10, 2); // Coffee with equal amounts of cream and sugar
        
        System.out.println(myMap);
    }
    
}

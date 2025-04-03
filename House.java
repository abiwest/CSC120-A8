import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building{
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * 
   * @param name
   * @param address
   * @param nFloors
   * @param hasDiningRoom
   * @param hasElevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    this.residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }

  /**
   * 
   * @param name
   * @param address
   * Creates default parameters for a house given name and address
   */
  public House(String name, String address) {
    this(name, address, 4, false, false);
  }

  /**
   * 
   * @return t/f if the house has a dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * 
   * @return t/f if the house has an elevator
   */
  public boolean hasElevator() {
    return this.hasElevator;
  }
  
  /**
   * 
   * @return the number of residents in the house
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * 
   * @param s
   * Moves student into the house, throws exception if the student already lives there
   */
  public void moveIn(Student s) {
    if (!residents.contains(s)) {
      residents.add(s);
      System.out.println(s.getName() + " has moved in!");
    } else {
      throw new RuntimeException("Sorry, " + s.getName() + " is already a resident");
    }
  }

  /**
   * 
   * @param students
   * Moves an array of students into the house
   */
  public void moveIn(ArrayList<Student> students) {
    for (Student s: students) {
      moveIn(s);
    }
  }

  /**
   * 
   * @param s
   * @return The student who has moved out. Also throws exception if the student was not a resident
   */
  public Student moveOut(Student s) {
    if (residents.contains(s)) {
      residents.remove(s);
      System.out.println(s.getName() + " has moved out!");
      return s;
    } else {
      throw new RuntimeException("Sorry, " + s.getName() + " is not a resident");
    }
  }

  /**
   * 
   * @param s
   * @return t/f if the student is a resident of the house
   */
  public boolean isResident(Student s) {
    return residents.contains(s);
  }

  /**
   * Shows all options that the house can implement
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + moveIn() \n + moveOut()");
  }

  /**
   * @param floorNum
   * overrides original elevator function if the Library doesn't have one
   */
  public void goToFloor(int floorNum) {
    if (!this.hasElevator) {
      throw new UnsupportedOperationException("Sorry, this house does not have an elevator. Feature unsupported.");
    } else {
      super.goToFloor(floorNum);
    }
  }

  public static void main(String[] args) {
    House h = new House("Haynes House", "1 Mandelle Road", 3, true, false); 
    Student a = new Student("Abi", 991123456);

    h.moveIn(a);
    h.moveOut(a);

    h.enter();
    h.goUp();
    h.goDown();

    h.goToFloor(3);
    h.goToFloor(1);
    h.exit();
    
    h.showOptions();
  
  }

}
import java.util.ArrayList;
import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building{
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /**
   * 
   * @param name
   * @param address
   * @param nFloors
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
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
   * Adds title to the collection
   * @param title
   */
  public void addTitle(String title) {
    collection.put(title, true);
    System.out.println(title + " has been added to the collection!");
  }

  /**
   * 
   * Overloads original addTitle function, allows us to add multiple titles
   * @param titles
   */
  public void addTitle(ArrayList<String> titles) {
    for (String title: titles) {
      addTitle(title);
    }
  }

  /**
   * 
   * Removes title from collection
   * @param title
   * @return title name
   */
  public String removeTitle(String title) {
    collection.remove(title);
    System.out.println(title + " has been removed from the collection!");
    return title;
  }

  /**
   * 
   * Overloads removeTitle to remove an array of titles instead of just one
   * @param titles
   */
  public void removeTitle(ArrayList<String> titles) {
    for (String title: titles) {
      removeTitle(title);
    }
  }

  /**
   * 
   * Checks if the book exists in the collection & is available, then sets the availability to false
   * @param title
   */
  public void checkOut(String title) {
    if (collection.containsKey(title) && collection.get(title)) { // Checking if the book exists AND is available
      collection.replace(title, false);
      System.out.println(title + " has been checked out");
    } else {
      throw new RuntimeException("Sorry, this book doesn't exist or has already been checked out");
    }
  }

  /**
   * 
   * Checks if the book is in the collection, then returns it by marking the availiabity as true
   * @param title
   */
  public void returnBook(String title) {
    if (collection.containsKey(title)) {
      collection.replace(title, true);
      System.out.println(title + " has been returned");
    } else {
      throw new RuntimeException("Sorry, this book is not in this library's collection");
    }
  }

  /**
   * 
   * @param title
   * @return t/f if the title is in the collection (library)
   */
  public boolean containsTitle(String title) {
    return collection.contains(title);
  }

  /**
   * 
   * @param title
   * @return t/f if the title is availible
   */
  public boolean isAvailable(String title) {
    return collection.getOrDefault(title, true);
  }

  /**
   * Prints list of every title in the collection and its availability
   */
  public void printCollection() {
    System.out.println("Books in collection: " + collection);
  }

  /**
   * Shows all options that the library can implement
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + printCollection()");
  }

  /**
   * Overrides original elevator function if the Library doesn't have one
   * @param floorNum
   */
  public void goToFloor(int floorNum) {
    if (!this.hasElevator) {
      throw new UnsupportedOperationException("Sorry, this library does not have an elevator. Feature unsupported.");
    } else {
      super.goToFloor(floorNum);
    }
  }
  
  public static void main(String[] args) {
    Library l = new Library("Neilson Library", "Smith College, Northampton MA", 4, false);

    l.addTitle("The Lorax by Dr. Seuss");
    l.addTitle("Matilda by Roald Dahl");

    l.printCollection();
    l.checkOut("The Lorax by Dr. Seuss");
    l.printCollection();
    l.returnBook("The Lorax by Dr. Seuss");
    l.printCollection();

    l.removeTitle("Matilda by Roald Dahl");
    l.printCollection();

    l.showOptions();

    l.enter();
    l.goToFloor(3);
  }
  
}
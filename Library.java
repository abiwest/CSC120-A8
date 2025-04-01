import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building{
  private Hashtable<String, Boolean> collection;

  /**
   * 
   * @param name
   * @param address
   * @param nFloors
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * 
   * @param title
   * Adds title to the collection
   */
  public void addTitle(String title) {
    collection.put(title, true);
  }

  /**
   * 
   * @param title
   * Removes title from collection
   * @return title name
   */
  public String removeTitle(String title) {
    collection.remove(title);
    return title;
  }

  /**
   * 
   * @param title
   * Checks if the book exists in the collection & is available, then sets the availability to false
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
   * @param title
   * Checks if the book is in the collection, then returns it by marking the availiabity as true
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
  
  public static void main(String[] args) {
    Library l = new Library("Neilson Library", "Smith College, Northampton MA", 4);

    l.addTitle("The Lorax by Dr. Seuss");
    l.addTitle("Matilda by Roald Dahl");

    l.printCollection();
    l.checkOut("The Lorax by Dr. Seuss");
    l.printCollection();
    l.returnBook("The Lorax by Dr. Seuss");
    l.printCollection();

    l.removeTitle("Matilda by Roald Dahl");
    l.printCollection();
  }
  
}
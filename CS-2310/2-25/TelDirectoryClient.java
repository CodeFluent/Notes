import java.util.*;



public class TelDirectoryClient {

  public static void main (String [] args) {

    ArrayList <TelDirectory> list1 = new ArrayList <TelDirectory>();

    list1.add(new TelDirectory("Jennifer TwoShoes", "770110111"));
    list1.add(new TelDirectory("Voldemort Facenose", "770110119"));
    list1.add(new TelDirectory("Waka Floca", "770110117"));
    list1.add(new TelDirectory("Whatev Bro", "770110115"));
    list1.add(new TelDirectory("Severus Snape", "770110113"));
    list1.add(new TelDirectory("Bob Marley", "770110110"));
    list1.add(new TelDirectory("Harry Potter", "770110114"));
    list1.add(new TelDirectory("BabaGonash Himdir", "770110112"));
    list1.add(new TelDirectory("This Is", "770110118"));
    list1.add(new TelDirectory("Stoopid Fool", "770110116"));

    System.out.println();
    System.out.println("------------Unsorted------------");
    System.out.println();
    for(int i = 0; i < list1.size() - 1; i++){
      System.out.println(list1.get(i));
    }

    System.out.println();
    System.out.println();
    System.out.println("------------Sorted------------");
    System.out.println();
    Collections.sort(list1);
    for(int i = 0; i < list1.size() - 1; i++){
      System.out.println(list1.get(i));
    }

  }
}

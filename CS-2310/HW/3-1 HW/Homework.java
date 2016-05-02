import java.util.*;



public class Homework {


  public static void reverse3 (ArrayList <Integer> list){


    for (int i = 0; i < list.size() - 2; i += 3) {
          list.add(i, list.remove(i + 2));
          list.add(i + 2, list.remove(i + 1));
        }

    for (Integer i : list) {
          System.out.println(i);
        }


  }

  public static void main (String [] args) {
    ArrayList <Integer> list1 = new ArrayList <Integer> ();
    list1.add(new Integer(10));
    list1.add(new Integer(13));
    list1.add(new Integer(2));
    list1.add(new Integer(8));
    list1.add(new Integer(7));
    list1.add(new Integer(90));
    list1.add(new Integer(-1));
    list1.add(new Integer(2));

    System.out.println("----------BEFORE CALL----------");
    for (Integer i : list1){
      System.out.println(i);
    }

    System.out.println();
    System.out.println("----------AFTER CALL----------");
    reverse3(list1);
  }

}

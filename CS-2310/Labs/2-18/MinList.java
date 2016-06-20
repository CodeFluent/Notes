import java.util.*;




public class MinList {

  public static void minToFront(ArrayList <Integer> list) {

    int min = 0; // captures smallest number in loop

    for (int i=1; i < list.size(); i++){
      if (list.get(i) < list.get(min)){
        min = i;
      }
    }
    int old = list.remove(min); // removes the old instance of the min from the list
    list.add(0, old); // adds to the front of the list

  }

  public static void filterRange (ArrayList <Integer> list, int min, int max) {

    for (int i=0; i < list.size(); i++){
        int current = list.get(i); //saves current value to current
        if (min <= current && current <= max){ // if current value is larger than min and smaller than max
          list.remove(i); // it is removed
          i--;
        }
      }

  }


  public static void main (String [] args) {

    // [4,7,9,2,7,7,5,3,5,1,7,8,6,7]
    ArrayList <Integer> list1 = new ArrayList <Integer>() {{
      add(4);
      add(7);
      add(9);
      add(2);
      add(7);
      add(7);
      add(5);
      add(3);
      add(5);
      add(1);
      add(7);
      add(8);
      add(6);
      add(7);
    }};

    // for FilterRange; not efficent if additional methods are required
    ArrayList <Integer> list2 = new ArrayList <Integer> ();

    for (Integer k : list1 ){
      list2.add(k);
    }


    System.out.println();
    System.out.println("------------MinToFront------------");

    System.out.println();
    System.out.println("Before Sorting");
    System.out.println();

    for (Integer i : list1) {
      System.out.print(i + ", ");
    }

    System.out.println();

    minToFront(list1);

    System.out.println();
    System.out.println("After Sorting");
    System.out.println();

    for (Integer j : list1) {
      System.out.print(j + ", ");
    }

    System.out.println();

    System.out.println();
    System.out.println("------------FilterRange------------");


    filterRange(list2,5,7);

    System.out.println();
    System.out.println("After Filtration");
    System.out.println();

    for (Integer l : list2) {
      System.out.print(l + ", ");
    }

    System.out.println();

  }
}

import java.util.*;

public class TelDirectory implements Comparable <TelDirectory>{

  public String name;
  public String phoneNumber;

  public TelDirectory (String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public int compareTo (TelDirectory t){
    int lastCmp = phoneNumber.compareTo(t.phoneNumber);
    return (lastCmp != 0 ? lastCmp : phoneNumber.compareTo(t.phoneNumber));
  }

  public String getName(){
    return name;
  }

  public String getPhoneNumber(){
    return phoneNumber;
  }

  public String toString() {
    return name + ", " + phoneNumber;
  }


}

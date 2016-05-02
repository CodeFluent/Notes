import java.util.*;



public class Date implements Comparable <Date> {

  public int day;
  public int month;
  public Integer year;

  public Date (int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public int compareTo (Date d){
    int lastCmp = year.compareTo(d.year);
    return (lastCmp != 0 ? lastCmp : year.compareTo(d.year));
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }


  public String toString() {
    return  day + "/" + month + "/" + year;
  }

}

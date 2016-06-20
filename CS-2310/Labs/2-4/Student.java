

public class Student extends Human {

  private String major;
  private double gpa;
  private int creditHours;

  Student(String major, double gpa, int creditHours, double height,
  float weight, int age){
    super(height);
    this.major = major;
    this.gpa = gpa;
    this.creditHours = creditHours;
    this.age = super.getMAge() + age;
  }

  public String getMajor(){
    return major;
  }

  public double getGPA(){
    return gpa;
  }

  public int getSAge(){
    return age;
  }


  public String getCollege(){

    String f1 = "Freshman";
    String f2 = "Sophomore";
    String f3 = "Junior";
    String f4 = "Senior";

    String empty = "";


    if (creditHours < 32){
      empty = f1;
    }
    else if ((creditHours > 32) && (creditHours < 64)){
      empty = f2;
    }
    else if ((creditHours >= 64) && (creditHours < 96)){
      empty = f3;
    }
    else if (creditHours >= 96){
      empty = f4;
    }

    return empty;

  }


}

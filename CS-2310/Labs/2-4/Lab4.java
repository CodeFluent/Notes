
public class Lab4 {

  public static void main(String [] args){

    Student alex = new Student("Computer Science", 3.4, 54, 170, 150, 18);
    Doctor jack = new Doctor(4, "Dermatology", 173, 179, 40 );

    System.out.println();
    
    System.out.println("Major: " + alex.getMajor());
    System.out.println("GPA: " + alex.getGPA());
    System.out.println("Year: "+ alex.getCollege());
    System.out.println("Age : " + alex.getSAge());

    System.out.println();

    System.out.println("Speciality: "+ jack.getSpecial());
    System.out.println("Height: "+ jack.getHeight());
    System.out.println("Weight: "+ jack.getMWeight());
    System.out.println("Salary: "+ jack.getSalary());

  }
}

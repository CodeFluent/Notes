

public class Doctor extends Human {

  private int years;
  private String special;

  Doctor(int years, String special, double height, float weight,
   int age){
    super(height);
    this.years = years;
    this.special = special;
    this.weight = super.getMWeight() + weight;

  }

  public int getYears() {
    return years;
  }

  public String getSpecial() {
    return special;
  }
  public double getSalary(){

    double baseSalary = 40000;
    double salary = 0.0;

    if (years == 1){
      return baseSalary;
    }
    else if (years > 1){

      for (int i = 1; i < years; i++){
        salary += 5000;
      }
      return baseSalary + salary;
    }
    else {
      return 0;
    }
  }

}

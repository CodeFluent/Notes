

public class Human extends Mammal {

  private double height;

  Human(double height) {
    super(weight, age);
    this.height = height;
  }

  public double getHeight() {
    return height;
  }

  public float getMWeight(){
    return super.getWeight();
  }
  public int getMAge(){
    return super.getAge();
  }


}


```
  class Mammal {

    private int age;
    private double weight;

    Mammal(float weight, int age) {

      this.age = age;
      this.weight =weight;
    }

    public float getWeight(){
      return weight;
    }

    public int getAge() {
      return age;
    }
  }
```

***
#### Client and Questions

- Write a client class called Lab4.java
- Create an object of class Student called alex whose major in CS, gpa is 3.4, credit hours 54, height is 170cm, weight is 150 pounds and age is 18
- Create an object of class Doctor called jack whose speciality is Dermatology, years = 4, height is 173 cm, weight is 179 punds and age is 40.
- Print out the student's major, gpa,year and age.
- Print out the doctor's speciality, height, weight, and salway

What will be the output after you execute the following statements ? Explain your answer.

  >Mammal man1 = jack;
  System.out.println((Man1).getSalary());

What will be the output after you execute the following statements? Explain your answer.

> Human hum1 = alex;
System.out.println(Hum1.getHeight());

What will be the output after you execute the following statements? Explain your answer.

> Mammal man1 = jack;
System.out.println(man1.getWeight());

What will be the output after you execute the following statements? Explain your answer.

> Mammal man1 = jack;
System.out.println((Human)man1.getHeight());


***
#### Human:
    Fields:
      - height (double)
    Methods:
      - getHeight: returns height

#### Student:
    Fields:
        -  major (String)
        -  gpa(double)
        -  creditHours(int)

    Methods:
        -  getMajor: return major
        -  getGPA: return GPA
        -  getYear: return freshman, sophmore ... etc depending on number of creditHours

           * Freshman: less that 32 hours
           * Sophomore: At least 32 hours but less than 64
           * Junior: At least Sophomore credit hours but less than 96
           * Senior: At least 96 credit Hours

#### Doctor:

    Fields:
        - years(int)
        - Speciality(String)

    Methods:
       - getYears: returns years
       - getSpeciality: return speciality
       - getSalary: calculates salary. base salary = 40000 if 1 year.
         and every additional year adds 5000 dollars

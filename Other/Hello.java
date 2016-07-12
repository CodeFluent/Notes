
public class Hello {

public static void main(String[] args) {

     System.out.print(1 + " ");
     int prevVal = 1;
     int prevPrevVal = 0;
     int n = 0;
     do{
         int currVal = prevVal + prevPrevVal;
         prevPrevVal = prevVal;
         prevVal = currVal;
         System.out.print(currVal+" ");
         n++;
     }while(n<5);//n is the number of terms


}
}

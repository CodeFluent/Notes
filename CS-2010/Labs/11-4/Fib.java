public class Fib
{

  public static void main(String[] args)
{
//constant for maximum fibonachi number
final int N = 20;
//previous number of fibonachi
int oldNum = 0;
//next number of fibonachi
int newNum = 1;

//the for loop
for(int i = 0; i < N; i++){
	System.out.println("Number " + (i+1) + " in fibonachi sequence is: " + oldNum + " + " + newNum + " = " + (oldNum + newNum));
	if(i > 0){
		int temp = newNum;
		newNum = oldNum + newNum;
		oldNum = temp;
	}
}
}
}

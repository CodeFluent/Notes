// Wasfi Momen
// Bing Li
// 12-12:50
// Lab 9


import java.util.Scanner;


public class Lab9{
	public static int calcLargestSum(int n1,int n2,int n3){
		int twothree = Math.max (n1, Math.max(n2,n3));
		int onetwo = Math.max(n1,n2);
		int sum = (twothree + onetwo);
		return sum	;
	}

	public static int calcMiddleNumber(int n1,int n2,int n3){
		if ( (n1 - n2) * (n3 - n1) >= 0 ){
	         return n1;
		}
	     else if ( (n2 - n1) * (n3 - n2) >= 0 ){
	         return n2;
		}
	     else {
	         return n3;
	 }
 }




public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("The first #:");
		int n1 = input.nextInt();
		System.out.print("The second #:");
		int n2 = input.nextInt();
		System.out.print("The third #:");
		int n3 = input.nextInt();

		System.out.println("The sum of the two largest numbers is "+calcLargestSum(n1,n2,n3));
		System.out.println("The median is "+calcMiddleNumber(n1,n2,n3));

	}

}

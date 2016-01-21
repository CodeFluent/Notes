
public class Numbers {

	public static void pattern() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= (-1 * i + 6); j++) {
				System.out.print(j + " ");

			}
			System.out.println();
		}
	}

	public static void odd_one_out() {

  for (int n = 10; n <= 70; n++){
		if(n%2!=0){
			System.out.println(n);
		}
	 }
 }

	public static void main(String[] args) {
		pattern();
		System.out.println("________________");
    System.out.println();
		odd_one_out();

	}

}

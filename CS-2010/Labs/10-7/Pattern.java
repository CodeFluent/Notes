public class Pattern {

	public static void method1() { 
		for(int i = 0 ;i < 8;i++){
			if (i<4){
				for(int j = 0;j<6-i*2;j++){
					System.out.print(" ");
				}
				for(int j = 1;j<=1+i*2;j++){
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}

	public static void method2() {
		for(int i = 0 ;i < 8;i++){
			if (i>3){
				for(int j = 0;j<2*(i-4);j++){
					System.out.print(" ");
				}
				for(int j = 1;j<=1+(7-i)*2;j++){
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}

	public static void method3() {
		
		for(int i = 0 ;i < 8;i++){
			if (i<4){
				for(int j = 0;j<6-i*2;j++){
					System.out.print(" ");
				}
				for(int j = 1;j<=1+i*2;j++){
					System.out.print("* ");
				}
			}else{
				for(int j = 0;j<2*(i-4);j++){
					System.out.print(" ");
				}
				for(int j = 1;j<=1+(7-i)*2;j++){
					System.out.print("* ");
				}
			}
			System.out.println();
		}

	}

	public static void main (String[] args) {
		
		method1(); //prints right side up triangle
		System.out.println();
		method2(); // prints upside down triangle
		System.out.println();
		method3(); //prints both triangles (upside down and right side up)
		
	}

}
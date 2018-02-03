
public class SelectionSort {
    public static void main (String [] args) {
        int i,j, first,temp;

        int [] num;

        for(i = num.length-1; i >0;i--) {
            first =0;
            for(j=1; j<=i;j++) {
                if (num[j] < num[first]) {
                    first = j;
                }
                temp = num[first];
                num[first] = num[i];
                num[i] = temp;
            }
        }

    }
}

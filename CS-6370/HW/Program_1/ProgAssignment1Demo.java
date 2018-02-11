/**
 * This is a structure for class CSc4222 Assignment1
 */
public class Assignment1Demo {

    private static String msg;
    private static String msgE;
    private static String msgD;
    private static int key;

    public static void main(String[] args){
        //TODO: You can only call methods in main method
        key = generateKey();
        msg = generateMsg();
        msgE = encryption(key,msg);
        bruteForce(msgE);
    }

    private static int generateKey() {
        //TODO: implement step a (randomly generate 16-bit key)
        return 0;
    }

    private static String generateMsg() {
        //TODO: implement step b (randonly generate a string with an even number of characters)
        return "";
    }

    private static String encryption(int key, String msg) {
        //TODO: implement step c (encrypt the message)
        return "";
    }

    private static void decryption(int key, String msgE) {
        //TODO: implement step d (decryption)
    }

    private static void bruteForce(String msgE) {
        //TODO: implement bruteForce algorithm, you may need the above decryption(key,msgE) method
    }


}

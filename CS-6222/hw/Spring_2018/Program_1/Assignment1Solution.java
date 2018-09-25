import java.util.Random;

/**
 * This is a solution for class CSc4222 Assignment1
 */
public class Assignment1Solution {

    private static String msg;
    private static String msgE;
    private static String msgD;
    private static String key;

    public static void main(String[] args) throws InterruptedException {
        //TODO: You can only call methods in main method
        key = generateKey();
        msg = generateMsg();
        msgE = encryption(key,msg);
        System.out.println("The encrypted message is: "+msgE);
        bruteForce(msgE);
    }

    private static String generateKey() {
        Random r = new Random(System.currentTimeMillis());
        int tempKey = r.nextInt(1 <<16);
        String keyString = Integer.toBinaryString(tempKey);
        int num = keyString.length();
        for(int i =0; i < 16-num; i++){
            keyString = "0"+keyString;
        }
        System.out.println("The key is: "+keyString);
        return keyString;
    }

    private static String generateMsg() {
        String library = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        String TempMsg = "";
        Random rand = new Random(System.currentTimeMillis());
        int length = 10;
        do{
            length = rand.nextInt(20)+10;
        }while (length%2!=0);
        for(int i=0; i<length;i++){
            TempMsg += library.charAt(rand.nextInt(53));
        }
        System.out.println("The message is: "+TempMsg);
        return TempMsg;
    }

    private static String encryption(String key, String msg) {
        //TODO: implement step c (encrypt the message)
        String result="";
        String newKey="";
        for(int i=0;i<msg.length()/2;i++) {
            newKey=newKey+key; //deal with the key
        }
        for(int i=0,j=0; i<msg.length(); i++,j+=8){
            result += (char)(msg.charAt(i)^Integer.parseInt(newKey.substring(j,j+8),2));
        }
        return result;
    }

    private static String decryption(String key, String msg) {
        //TODO: implement step d (decryption)
        return encryption(key,msg); //decryption and encryption use same formulation

    }

    private static void bruteForce(String msgE) throws InterruptedException {
        //TODO: implement bruteForce algorithm, you may need the above decryption(key) method
        for(int i=0;i<65535;i++){//iterate all the possible keys
            String keyString = Integer.toBinaryString(i);
            int num = keyString.length();
            for(int j =0; j < 16-num; j++){
                keyString = "0"+keyString;
            }
            msgD = decryption(keyString,msgE);
            if (msgD.matches("[a-zA-Z ]+")) {
                System.out.println("The decrypted message is: " + msgD);
                System.out.println("The used key is: " + keyString);
                break;
            }
        }
    }

}

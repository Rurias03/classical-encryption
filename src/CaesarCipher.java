/**
 * The Caesar Cipher implemented in Java; Have a particular key n and with that key, add and
 * subtract to each character of a given message to encrypt and decrypt respectfully.
 * 
 * @author Rene Urias Jr
 * @version 1.? of 23 September 2023
 */
public class CaesarCipher {
    public static void main(String[] args) {
        // Check if the correct number of arguments is provided
        if (args.length != 2) {
            System.err.println("Incorrect number of parameters");
            System.exit(2);
        } // if()

        String action = args[0]; // Get the action (encode or decode) from the command-line
                                 // arguments
        String message = args[1]; // Get the message to be encoded or decoded from the command-line
                                  // arguemnts

        // Check if the action is either "encode" or "decode"
        if (!action.equals("encode") && !action.equals("decode")) {
            System.err.println("Valid option are \"encode\" or \"decode\"");
            System.exit(1);
        } // if()

        // Check if the message contains only lowercase characters
        if (!CipherUtils.isLowerCase(message)) {
            System.err.println("Input should consist only of lowercase characters");
            System.exit(1);
        } // if()

        // Perform the specified action (encode or decode) for all possible shift values (0 to 25)
        for (int n = 0; n < 26; n++) {
            String result = (action.equals("encode")) ? encode(message, n) : decode(message, n);
            System.out.println("n = " + n + ": " + result);
        } // for()
    } // main(String)

    // Function to encode a message using the Caesar Cipher with a given shift value (n)
    public static String encode(String message, int n) {
        return CipherUtils.caesarCipher(message, n, true);
    } // encode(String, int)

    // Helper function to decode the message
    public static String decode(String message, int n) {
        return CipherUtils.caesarCipher(message, n, false);
    } // decode(String, int)
} // class CaesarCipher

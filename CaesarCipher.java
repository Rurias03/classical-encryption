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
        if (!isLowerCase(message)) {
            System.err.println("Input should consist only of lowercase characters");
            System.exit(1);
        } // if()

        // Perform the specified action (encode or decode) for all possible shift values (0 to 25)
        for (int n = 0; n < 26; n++) {
            String result = (action.equals("encode")) ? encode(message, n) : decode(message, n);
            System.out.println("n = " + n + ": " + result);
        } // for()
    } // main(String)

    // Function to check if a string contains only lowercase characters
    public static boolean isLowerCase(String s) {
        for (char ch : s.toCharArray()) {
            if (ch < 'a' || ch > 'z') {
                return false;
            } // if()
        } // for()
        return true;
    } // isLowerCase(String)

    // Function to encode or decode a message using the Caesar Cipher with a given shift value (n)
    public static String processMessage(String message, int n, boolean encode) {
        char[] result = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                char shiftedChar = (char) (((ch - 'a' + (encode ? n : -n) + 26) % 26) + 'a');
                result[i] = shiftedChar;
            } else {
                result[i] = ch; // Keep non-lowercase characters unchanged
            } // if() . . . else()
        } // for()
        return new String(result);
    } // processMessage(String, int, boolean)

    // Function to encode a message using the Caesar Cipher with a given shift value (n)
    public static String encode(String message, int n) {
        return processMessage(message, n, true);
    } // encode(String, int)

    // Helper function to decode the message
    public static String decode(String message, int n) {
        return processMessage(message, n, false);
    } // decode(String, int)
} // class CaesarCipher

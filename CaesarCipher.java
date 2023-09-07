public class CaesarCipher {
    public static void main(String[] args) {
        // Check if the correct number of arguments is provided
        if (args.length != 2) {
            System.err.println("Incorrect number of parameters");
            System.exit(2);
        }

        String action = args[0]; // Get the action (encode or decode) from the command-line arguments
        String message = args[1]; // Get the message to be encoded or decoded from the command-line arguemnts

        //Check if the action is either "encode" or "decode"
        if (!action.equals("encode") && !action.equals("decode")) {
            System.err.println("Valid option are \"encode\" or \"decode\"");
            System.exit(1);
        }

        // Check if the message contains only lowercase characters
        if (!isLowerCase(message)) {
            System.err.println("Input should consist only of lowercase characters");
            System.exit(1);
        }        

        // Perform the specified action (encode or decode) for all possible shift values (0 to 25)
        if (action.equals("encode")) {
            for (int n = 0; n < 26; n++) {
                String encoded = encode(message, n);
                System.out.println("n = " + n + ": " + encoded);
            }
        } else{
            for (int n = 0; n < 26; n++) {
                String decoded = decode(message, n);
                System.out.println("n = " + n + ": " + decoded);
            }
        }
    } // main

    // Function to check if a string contains only lowercase characters
    public static boolean isLowerCase(String s) {
        for (char ch : s.toCharArray()) {
            if (ch < 'a' || ch > 'z') {
                return false;
            }
        }
        return true;
    } // isLowerCase

    // Function to encode a message using the Caesar Cipher with a given shift value (n)
    public static String encode(String message, int n) { 
        char[] result = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                char encodedChar = (char) (((ch - 'a' + n) % 26) + 'a');
                result[i] = encodedChar;
            } else {
                result[i] = ch; // Keep non-lowercase characters unchanged
            }
        }
        return new String(result);
    } // encode

    // Helper function to decode the message
    public static String decode(String message, int n) {
        char[] result = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                char decodedChar = (char) (((ch - 'a' - n + 26) % 26) + 'a');
                result[i] = decodedChar;
            } else {
                result[i] = ch;
            }
        }
        return new String(result);
    } // decode
} // CaesarCipher

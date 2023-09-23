/**
 * The Vigenere Cipher implemented in Java; Similar to the Caesar Cipher in this repository,
 * however, unlike it that has a fixed key, this cipher uses a keyword to shift text
 * 
 * @author Rene Urias Jr
 * @version 1.? of 23 September 2023
 */
public class VigenereCipher {
    public static void main(String[] args) {
        // Check if the correct number of arguments is provided
        if (args.length != 3) {
            System.err.println("Incorrect number of parameters");
            System.exit(2);
        } // if()

        String action = args[0];
        String message = args[1];
        String keyword = args[2];

        // Check if the action is either "encode" or "decode"
        if (!action.equals("encode") && !action.equals("decode")) {
            System.err.println("Valid options are \"encode\" or \"decode\"");
            System.exit(1);
        } // if()

        // Check if the plaintext/ciphertext and keyword consist only of lowercase characters
        if (!isLowerCase(message) || !isLowerCase(keyword)) {
            System.err.println("Input should consist only of lowercase characters");
            System.exit(1);
        } // if()

        String result = "";
        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            char keywordChar = keyword.charAt(i % keyword.length()); // Replicate the keyword
            char shiftedChar;

            if (action.equals("encode")) {
                shiftedChar = shift(messageChar, keywordChar, true);
            } else {
                shiftedChar = shift(messageChar, keywordChar, false);
            } // if() . . .else()
            result += shiftedChar;
        } // for()
        System.out.println(result);
    } // main(String)

    // Function to check if a string consists only of lowercase characters
    public static boolean isLowerCase(String s) {
        for (char ch : s.toCharArray()) {
            if (ch < 'a' || ch > 'z') {
                return false;
            } // if()
        } // for()
        return true;
    } // isLowerCase(String)

    // Function to perform the Vigenere shift for encoding
    public static char shift(char messageChar, char keywordChar, boolean encode) {
        int shift = keywordChar - 'a';
        return (char) (((messageChar - 'a' + (encode ? shift : -shift) + 26) % 26) + 'a');
    } // shift(char, char, boolean)
} // class VigenereCipher

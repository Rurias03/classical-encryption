public class VigenereCipher {
    public static void main(String[] args) {
        // Check if the correct number of arguments is provided
        if (args.length != 3) {
            System.err.println("Incorrect number of parameters");
            System.exit(2);
        }

        String action = args[0];
        String message = args[1];
        String keyword = args[2];

        // Check if the action is either "encode" or "decode"
        if (!action.equals("encode") && !action.equals("decode")) {
            System.err.println("Valid options are \"encode\" or \"decode\"");
            System.exit(1);
        }

        // Check if the plaintext/ciphertext and keyword consist only of lowercase characters
        if (!isLowerCase(message) || !isLowerCase(keyword)) {
            System.err.println("Input should consist only of lowercase characters");
            System.exit(1);
        }

        String result = "";
        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            char keywordChar = keyword.charAt(i % keyword.length()); // Replicate the keyword
            char shiftedChar;

            if (action.equals("encode")) {
                shiftedChar = shift(messageChar, keywordChar);
            } else {
                shiftedChar = unshift(messageChar, keywordChar);
            }
            result += shiftedChar;
        }
        System.out.println(result);
    } // main

    // Function to check if a string consists only of lowercase characters
    public static boolean isLowerCase(String s) {
        for (char ch : s.toCharArray()) {
            if (ch < 'a' || ch > 'z') {
                return false;
            }
        }
        return true;
    } // isLowerCase()

    // Function to perform the Vigenere shift for encoding
    public static char shift(char messageChar, char keywordChar) {
        int shift = keywordChar - 'a';
        return (char) (((messageChar - 'a' + shift) % 26) + 'a');
    } // shift()

    // Function to perform the Vigenere shift for decoding
    public static char unshift(char messageChar, char keywordChar) {
        int shift = keywordChar - 'a';
        return (char) (((messageChar -'a' - shift + 26) % 26) + 'a'); 
    } // unshift()
} // VigenereCipher
/**
 * Utility class for common cipher operations if the Caesar and Vigenere Cipher classes
 * 
 * @author Rene Urias Jr
 * @version 1.0 of 23 September 2023
 */
public class CipherUtils {
  /**
   * Check if a string contains only lowercase characters
   * 
   * @param s The input string to check
   * @return true If the string consists of only lowercase characters false otherwise
   */
  public static boolean isLowerCase(String s) {
    for (char ch : s.toCharArray()) {
      if (ch < 'a' || ch > 'z') {
        return false;
      } // if()
    } // for()
    return true;
  } // isLowerCase(String)

  /**
   * Encode or decode a message using the Caesar Cipher with a given shift value (n)
   * 
   * @param message The input message to be encoded or decoded
   * @param n The shift value (n) for the Caesar Cipher
   * @param encode true to encode the message, false to decode
   * @return The encoded or decoded message
   */
  public static String caesarCipher(String message, int n, boolean encode) {
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
  } // caesarCipher(String, int, boolean)

  /**
   * Perform the Vigenere shift for encoding or decoding
   * 
   * @param messageChar The character from the message
   * @param keywordChar The character from the Vigenere keyword
   * @param encode true to encode the character, false to decode
   * @return The shifted character
   */
  public static char vigenereShift(char messageChar, char keywordChar, boolean encode) {
    int shift = keywordChar - 'a';
    return (char) (((messageChar - 'a' + (encode ? shift : -shift) + 26) % 26) + 'a');
  } // vigenereShift(char, char, boolean)
} // class CipherUtils

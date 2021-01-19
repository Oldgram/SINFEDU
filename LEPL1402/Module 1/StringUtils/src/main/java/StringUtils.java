import java.util.ArrayList;
import java.util.List;

public class StringUtils {


    /**
     * Split a string according to a delimiter
     *
     * @param str The string to split
     * @param delimiter The delimiter
     * @return An array containing the substring which fall
     *          between two consecutive occurrence of the delimiter.
     *          If there is no occurrence of the delimiter, it should
     *          return an array of size 1 with the string at element 0
     */
    public static String [] split(String str, char delimiter){
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter) {
                count++;
            }
        }

        String[] arrStr = new String[count];

        if (count == 1) {
            arrStr[0] = str;
            return arrStr;
        }

        int currWordInd = 0;
        StringBuilder currWord = new StringBuilder();

        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == delimiter) {
                arrStr[currWordInd] = currWord.toString();
                currWordInd += 1;
                currWord = new StringBuilder();
            } else {
                currWord.append(str.charAt(j));
            }
        }

        arrStr[currWordInd] = currWord.toString();
        return arrStr;
    }


    /**
     * Find the first occurrence of a substring in a string
     *
     * @param str The string to look in
     * @param sub The string to look for
     * @return The index of the start of the first appearance of
     *          the substring in str or -1 if sub does not appear
     *          in str
     */
    public static int indexOf(String str, String sub){
        int occ = -1;

        for (int i = 0; i <= str.length()-sub.length(); i++) {
            if (str.startsWith(sub, i)) {
                occ = i;
                break;
            }
        }

        return occ;
    }


    /**
     * Convert a string to lowercase
     *
     * @param str The string to convert
     * @return A new string, same as str but with every
     *          character put to lower case.
     */
    public static String toLowerCase(String str) {
        StringBuilder lowerCaseStr = new StringBuilder();
        String[] majChar = {"A","Z","E","R","T","Y","U","I","O","P","Q","S","D","F","G","H","J","K","L","M",
                "W","X","C","V","B","N"};
        String [] minChar = {"a","z","e","r","t","y","u","i","o","p","q","s","d","f","g","h","j","k","l","m",
                "w","x","c","v","b","n"};

        for (int i = 0 ; i < str.length(); i++){
            int index = -1;
            for (int j = 0; j< majChar.length; j++) {
                if (str.charAt(i) == majChar[j].charAt(0)){
                    index = j;
                }
            }
            if (index == -1){
                lowerCaseStr.append(str.charAt(i));
            } else {
                lowerCaseStr.append(minChar[index]);
            }
        }
        return lowerCaseStr.toString();
    }


    /**
     * Check if a string is a palindrome
     *
     * A palindrome is a sequence of character that is the
     * same when read from left to right and from right to
     * left.
     *
     * @param str The string to check
     * @return true if str is a palindrome, false otherwise
     */
    public static boolean palindrome(String str){
        StringBuilder reversing = new StringBuilder();

        String reversed = reversing.append(str).reverse().toString();

        return str.equals(reversed);
    }


}

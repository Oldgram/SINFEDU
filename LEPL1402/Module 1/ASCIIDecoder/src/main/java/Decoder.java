import java.util.ArrayList;
import java.util.Objects;

public class Decoder {

    /*
     * Forbidden characters are passed as an array of int.
     * Each element of this array correspond to the decimal ASCII code
     * of a forbidden character OR null if there's no forbidden character
     * If you encounter one of these forbidden character
     * you must ignore it when you translate your sentence.
     *
     * the 2D array "sentences" contain a set of decimal ASCII code we want you
     * to translate. Each sub-element of this array is a different sentence.
     * Ex : if we pass this array : [ ["42", "72", "88"], ["98", "99", "111", "47", "55"]]
     * to your decode method, you should return : [ "*HX", "bco/7" ]
     *
     * You should NEVER return null or an array containing null
     */
    public static String [] decode(int[] forbidden, String[][] sentences){
        int forbLength = 0;
        if (forbidden != null) {
            forbLength = forbidden.length;
        }

        boolean isForbidden = false;
        String [] decodedSentences = new String[sentences.length];

        for (int i = 0; i < sentences.length; i++) {
            StringBuilder currSent = new StringBuilder();

            for (int j = 0; j < sentences[i].length; j++) {
                if (forbLength > 0) {
                    for (int k = 0; k < forbLength; k++) {
                        int a = Integer.parseInt(sentences[i][j]), b = forbidden[k];
                        if (a == b) {
                            isForbidden = true;
                            break;
                        }
                    }
                    if (isForbidden) {
                        isForbidden = false;
                    } else {
                        String currChar = Character.toString((char)(Integer.parseInt(sentences[i][j])));
                        currSent.append(currChar);
                    }
                } else {
                    String currChar = Character.toString((char)(Integer.parseInt(sentences[i][j])));
                    currSent.append(currChar);
                }
            }
            decodedSentences[i] = currSent.toString();
        }
        return decodedSentences;
    }

}
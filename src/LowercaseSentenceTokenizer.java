import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A tokenizer that converts text input to lowercase and splits it 
 * into a list of tokens, where each token is either a word or a period.
 */
public class LowercaseSentenceTokenizer implements Tokenizer {
  /**
   * Tokenizes the text from the given Scanner. The method should 
   * convert the text to lowercase and split it into words and periods.
   * Words are separated by spaces, and periods are treated as separate tokens.
   * 
   * For example:
   * If the input text is: "Hello world. This is an example."
   * The tokenized output should be: ["hello", "world", ".", "this", "is", "an", "example", "."]
   * 
   * Notice that the text is converted to lowercase, and each period is treated as a separate token.
   * 
   * However, a period should only be considered a separate token if it occurs at the end
   * of a word. For example:
   * 
   * If the input text is: "Hello world. This is Dr.Smith's example."
   * The tokenized output should be: ["hello", "world", ".", "this", "is", "dr.smith's", "example", "."]
   * 
   * The internal period in Dr.Smith's is not treated as its own token because it does not occur at the end of the word.
   * 
   * @param scanner the Scanner to read the input text from
   * @return a list of tokens, where each token is a word or a period
   */
  public List<String> tokenize(Scanner scanner) {
    // TODO: Implement this function to convert the scanner's input to a list of words and periods
    
    //We need to return a list so make an empty list
    List<String> tokenList = new ArrayList<>();
    
    // while we have a next item in the scanner
    while (scanner.hasNext()) {
      
      // storing the next item as a variable
      // using toLowerCase to get the lowercase string
      String word = scanner.next().toLowerCase();

      // if the word ends with a period
      if (word.endsWith(".")) {

        // save the word separately using substring, with an adjustment of 1 for period
        String noPeriod = word.substring(0, word.length() - 1);

        // add the substring and a period to the tokenList
        tokenList.add(noPeriod);
        tokenList.add(".");
      } else {

        // if it doesn't meet the above conditions we can just add it to the tokenList
        tokenList.add(word);
      }
    }
    // test print
    // System.out.println(tokenList);

    return tokenList;
  }
}


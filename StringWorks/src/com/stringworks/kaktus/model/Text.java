/**
 * Top level class that has Parse function wordpool and list of sentences
 */
package com.stringworks.kaktus.model;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author kaktus
 *
 */
public class Text {
  static final String PUNCT_MARKS= ".,! ?";
  
  LinkedList<Sentence> text;
  TreeMap <Word, Word> wordPool; //pool for sorting words and better memory usage
  
  public Text () {
    text = new LinkedList<Sentence> ();
    wordPool = new TreeMap<Word, Word> (new WordComparator());
  }
  
  public void add (Sentence sentence) {
    text.add(sentence); 
  }
  
  public TreeMap<Word,Word> getWordPool () {
    return new TreeMap<Word, Word> (wordPool);
  }
  
  public LinkedList<Sentence> getText() {
    return new LinkedList<Sentence> (text);
  }
  
  // adds word through Treemap for better memory usage and sorted storage
  private Word addWordThroughPool (Word word) {
    if (!wordPool.containsKey(word)) {
      wordPool.put(word, word);
    }
    return wordPool.get(word);
  }
  // method that disassemble string to sentences and words/punctuation marks
  public void Parse (String input) {
    Sentence result = new Sentence();
    result.setRedline(true);
    char[] array = input.toCharArray();
    for(int i=0; i<array.length; ++i) { // Main FOR; i - increment in this cycle
      if (Character.isLetter(array[i])){
        Word word = new Word();
        for (;(i<array.length && PUNCT_MARKS.indexOf(array[i])<0) && // i - increment in this cycle. 
            (Character.isLetter(array[i]) ||  array[i] == '\''  //Monster-cycle that sense letters
            || array[i] == '-' ); ++i) { 
          word.add(new Letter(array[i]));
        }
        result.add(addWordThroughPool(word));
        --i;
        continue;
      }
      switch (array[i]) {
        case '\u0009': // TAB symbol
          result.add(new PunctMark(' '));
          break;
        case ' ':
          result.add(new PunctMark(' ')); //whitespace hunter
          for (;i<array.length &&  array[i] == ' ';++i) {} // i - increment in this cycle
          --i;
          break;
        case '.': // End of sentence catcher
        case '!':
        case '?':
          if (i+1<array.length) { // if we have some sentence ending punct mk and string is not ending, 
            result.add(new PunctMark(array[i]));
            if (!Character.isLetter(array[i]) && !Character.isDigit(array[i])){ // than if this is not construction like Object.toString()
              text.add(result); // we save our sentence
              result = new Sentence (); // and start another one with redline = false;
            }
          } else {
            result.add(new PunctMark(array[i])); // if it's string ending, then sentence will be saved after FOR ending
          }
          break;
        default:
          result.add(new PunctMark(array[i])); 
      }
      
    }
    text.add(result);
  }

}

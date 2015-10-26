/**
 * Class that creates that extends Symbol
 * Class has static constant that handles vowels for russian, ukranian and english language.
 * And other static const with strange letters that are not vowels or consonat
 * It stores type of letter (consonat or vowel)
 */

package com.stringworks.kaktus.model;


public class Letter extends Symbol implements Comparable<Letter> {
  boolean vowel=false;
  boolean consonat=false;
  private static final String VOWELS = "‡Â˝∏∫Ó˛ËˇÂÛ≥˚øaeiou";
  private static final String NOT_CONSONAT = "˙¸";

  public Letter (Character c) {
    super (c);
    vowel = (VOWELS.indexOf(c)>-1 || VOWELS.toUpperCase().indexOf(c)>-1);
    consonat = (!isVowel() && isLetter()&& NOT_CONSONAT.indexOf(Character.toLowerCase(c))>-1);
  }
  
  public Letter (Symbol c) {
  this(c.symbol);
  }
  
  public boolean isVowel () {
    return vowel;
  }
  
  public boolean is—onsonant (){
    return consonat;
  }

  @Override
  public int compareTo(Letter o) {
    return Character.toLowerCase(this.symbol)-(Character.toLowerCase(o.symbol));
  }
  
  
  
}

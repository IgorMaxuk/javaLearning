package com.stringworks.kaktus.model;

import java.util.ArrayList;
import java.util.Comparator;

public class Word  implements Comparable<Word>, PartOfSentence{
  
  ArrayList <Letter> letters;
  boolean lettersWord = false;
  int vowelCount;
  int consonatCount;
  double vowelFactor;
  
  public Word (){
    letters = new ArrayList <Letter> ();
  }
  
  public Word (ArrayList<Letter> input){
    letters=new ArrayList<>(input);
    countLetters();
    
  }

  /**
   * @return the letters
   */
  private ArrayList<Letter> getLetters() {
    return new ArrayList<Letter>(letters);
  }

  /**
   * @return the lettersWord
   */
  private boolean isLettersWord() {
    return lettersWord;
  }

  /**
   * @return the vowelCount
   */
  private int getVowelCount() {
    return vowelCount;
  }

  /**
   * @return the consonatCount
   */
  private int getConsonatCount() {
    return consonatCount;
  }

  /**
   * @return the vowelFactor
   */
  public double getVowelFactor() {
    return vowelFactor;
  }

  @Override
  public int compareTo(Word o) {
    
    int result= Double.compare(vowelFactor, o.vowelFactor);
    if (result == 0) {
      for (int i=0;i<this.letters.size() && i<o.letters.size() && result == 0;++i) {
        result = this.letters.get(i).compareTo(o.letters.get(i));
      }
    }
    return result;
    
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder buffer = new StringBuilder();
    for (Letter element:letters) {
      buffer.append(element.getSymbol());
    }
    return buffer.toString();
  }
  
  public void add (Letter inputLetter) {
    if (inputLetter!=null) {
      letters.add(inputLetter);
      countLetters();
    }
  }
  
  //
  
  public void countLetters () { 
    vowelCount = 0;
    consonatCount = 0;
    for (Letter element : letters) {
      if (element.isVowel()) {
        ++vowelCount;
      }
      if (element.isConsonant()) {
        ++consonatCount;
      }
    }
    vowelFactor = (double) vowelCount/ (double)letters.size();
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + consonatCount;
    result = prime * result + ((letters == null) ? 0 : letters.hashCode());
    result = prime * result + (lettersWord ? 1231 : 1237);
    result = prime * result + vowelCount;
    long temp;
    temp = Double.doubleToLongBits(vowelFactor);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Word other = (Word) obj;
    if (consonatCount != other.consonatCount)
      return false;
    if (letters == null) {
      if (other.letters != null)
        return false;
    } else if (!letters.equals(other.letters))
      return false;
    if (lettersWord != other.lettersWord)
      return false;
    if (vowelCount != other.vowelCount)
      return false;
    if (Double.doubleToLongBits(vowelFactor) != Double.doubleToLongBits(other.vowelFactor))
      return false;
    return true;
  }
  
  
  
}
class WordComparator implements Comparator<Word> {

  @Override
  public int compare(Word o1, Word o2) {
    return o1.compareTo(o2);
  }
  
}

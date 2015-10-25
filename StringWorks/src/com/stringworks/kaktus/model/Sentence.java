/**
 * 
 */
package com.stringworks.kaktus.model;

import java.util.ArrayList;

/**
 * @author kaktus
 *
 */
public class Sentence {
  ArrayList<PartOfSentence> sentence ;
  boolean redline = false;
  
  
  public Sentence (ArrayList<PartOfSentence> sentence){
    this.sentence = new ArrayList<PartOfSentence> (sentence);
  }
  
  public Sentence () {
    this.sentence = new ArrayList<PartOfSentence> ();
  }
  
  public PartOfSentence get (int element) {
    return sentence.get(element);
  }
  
  public void add (PartOfSentence element) {
    sentence.add(element);
  }


  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder buffer = new StringBuilder();
    for (PartOfSentence element : sentence){
      buffer.append(element.toString());
    }
    return buffer.toString();
  }

  /**
   * @return the redline
   */
  public boolean isRedline() {
    return redline;
  }

  /**
   * @param redline the redline to set
   */
  public void setRedline(boolean redline) {
    this.redline = redline;
  }
  
  

}

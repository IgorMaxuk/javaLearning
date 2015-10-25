/**
 * Any symbol that not letter is punctuation mark 
 */
package com.stringworks.kaktus.model;

/**
 * @author kaktus
 *
 */
public class PunctMark extends Symbol implements PartOfSentence {

  public PunctMark(Character c) {
    super(c);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.symbol);
    return sb.toString();
  }
  
  

}

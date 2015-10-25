/**
 * Base abstract class
 */


package com.stringworks.kaktus.model;


public abstract class Symbol {
  protected Character symbol;
  
  public Symbol (Character c){
    this.symbol=c;
  }
  
  public boolean isLetter() {
    return Character.isLetter(symbol);
  }

  /**
   * @return the symbol
   */
  public Character getSymbol() {
    return symbol;
  }
  
}

/**
 * ������� ��������� ��������� ������ �������� �� ���������������� � �������������� �������: 
 * ������, �����, �����������, ���� ���������� � ��. 
 * �� ���� ������� � ������������� ������ �������� ��������� � ������������������ �������� ����� ��������.
 * 7.   �������������� ����� ������ �� ����������� ���� ������� ���� (��������� ���������� ������� � ������ ���������� ���� � �����).
 */

package com.stringworks.kaktus.view;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;

import com.stringworks.kaktus.controller.FileReader;
import com.stringworks.kaktus.model.Sentence;
import com.stringworks.kaktus.model.Text;
import com.stringworks.kaktus.model.Word;

public class Main {

  public static void main(String[] args) {
    try {
      FileReader reader = new FileReader ("D:/Text2Parse.txt");
      ArrayList<String> arguments = new ArrayList<> (reader.get());
      Text text = new Text();
      for (String element:arguments) {
        text.Parse(element);
      }
      TreeMap<Word,Word> wordMap = text.getWordPool();
      for (Word word:wordMap.keySet()) {
        System.out.println(word.toString()+ " "+ word.getVowelFactor());
      }
      for (Sentence element : text.getText()) {
        if (element.isRedline()){
          System.out.println("");
        }
        System.out.print(element.toString());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    
  }

}

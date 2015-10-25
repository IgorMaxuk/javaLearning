package com.stringworks.kaktus.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReader {
  protected BufferedReader reader;
  private File f; 

  
  public FileReader(String filePath) throws FileNotFoundException {
      f = new File(filePath);
      if (!f.canRead()) {
          throw new FileNotFoundException("File '" + f.getAbsolutePath() + "' - not found!");
      }
  }

  public ArrayList<String> get() {
      try {
        ArrayList<String> result= new ArrayList<>();
          Init();
          String line;
          while ((line = reader.readLine()) != null) {
              result.add(line);
          }
          reader.close();
          return result;
      } catch (IOException e) {
          WriteReadingError();
      }
      return null;
  }
  protected void Init() throws IOException {
      reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
  }
  
  protected void WriteReadingError() {
      System.out.println("Ошибка чтения файла: " + f.getAbsolutePath() + "!");
  }
}


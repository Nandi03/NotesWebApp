package uk.ac.ucl.model;

import java.io.IOException;
import java.util.*;
import java.io.FileWriter;


public class Model {

  private String noteName;
  private final FileOperations file = new FileOperations();


  public void setName(String name){
    this.noteName = name;

  }

  // Get the names of all notes that currently exist.
  public List<String> getNoteNames() {
    List<String> noteNames;
    noteNames = file.readFile();

    return noteNames;
  }


  // Get the names of notes in sorted order.
  public List<String> getSortedNames(List<String> sortedList){
    sortedList.sort(String.CASE_INSENSITIVE_ORDER);

    return sortedList;
  }

  // Create a new text file to create a new note.
  public boolean createNote(String newName) throws IOException {

    return file.createFile(newName);
  }

  // Update the contents of the text file everytime a note is edited by the user.
  public void updateNote(String text, String url, String img) throws IOException {

    FileWriter writer = file.writeToFile(noteName, false);
    String data = noteName + "\n" + img + "\n" + url + "\n" + text + "\n";
    writer.write(data);
    writer.close();

  }

  // Gets the list of names that match the user's search.
  public List<String> searchFor() {

    boolean found;
    List<String> searchResults = new ArrayList<>();
    List<String> noteNames = getNoteNames();

    for (String name : noteNames) {
      if (name.contentEquals(noteName)) {
        searchResults.add(name);
      }
      else {
        found = search(name);
        if (found) {
          searchResults.add(name);
        }
      }

    }

    return searchResults;
  }

  // Compares each note name to the name being searched for to check if the user input is a substring.
  private boolean search(String name) {
    int i = 0;
    int j = 0;

    while (i < name.length() && j < noteName.length()) {
      char a = name.charAt(i);
      char b = noteName.charAt(j);
      if (a == b) {
        i += 1;
        j += 1;
      }
      else {
        i = i - j + 1;
        j = 0;
      }
    }
    return j == noteName.length();
  }

  // Update the list of note names when a note has been deleted or renamed.
  private void updateNames(List<String> listNames) throws IOException {
    FileWriter writer = file.writeToFile("noteNames", false);
    writer.write(listNames.get(0) + "\n");
    writer.close();
    writer = file.writeToFile("noteNames", true);
    int i = listNames.size();
    for(int n = 1; n < i; n++){
      writer.write(listNames.get(n) + "\n");
    }
    writer.close();
  }

  // Append the name of a new note to the list of names.
  public void addName() throws IOException {
    FileWriter writer = file.writeToFile("noteNames", true);
    writer.write(noteName + "\n");
    writer.close();
  }

  // Delete the file of the note and update the list of note names when a note is deleted.
  public void deleteNote() throws IOException {
    boolean deleted = file.deleteFile(noteName);
    if(deleted) {
      List<String> listNames = getNoteNames();
      listNames.remove(noteName);
      updateNames(listNames);
    }

  }

  // Update the text file names when a note is renamed.
  public boolean changeName(String newName) throws IOException {
    deleteNote();
    boolean created = createNote(newName);
    List<String> listNames = getNoteNames();
    int i = listNames.size();

    for(int n = 0; n < i; n++){
      if(listNames.get(n).equals(noteName)){
        listNames.set(n, newName);
      }
    }
    updateNames(listNames);

    return created;

  }

}


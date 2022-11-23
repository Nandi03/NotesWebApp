package uk.ac.ucl.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {

    // Opens a file given a name in read mode.
    public Scanner openFile(String name) {
        try {
            File notes = new File("./data/" + name + ".txt");
            Scanner reader = new Scanner(notes);
            return reader;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    // Read the file containing all the notes names and return a list of the names of the notes.
    public List<String> readFile() {
        List<String> noteNames = new ArrayList<>();

        Scanner reader = openFile("noteNames");
        while (true) {
            assert reader != null;
            if (!reader.hasNextLine()) break;
            String data = reader.nextLine();
            noteNames.add(data);
        }

        reader.close();
        return noteNames;
    }

   // Create a new text file with the given name.
   public boolean createFile(String noteName) throws IOException {

       File newNote = new File("./data/" + noteName + ".txt");
       return newNote.createNewFile();
   }

   // Open a text file in write mode.
   public FileWriter writeToFile(String fileName, boolean b) throws IOException {

        return new FileWriter("./data/" + fileName + ".txt", b);
    }

    // Delete a text file given its name.
    public boolean deleteFile(String fileName) {
        File f = new File("./data/" + fileName + ".txt");
        return f.delete();
    }
}

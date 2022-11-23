package uk.ac.ucl.model;

import java.util.Scanner;


public class Note {
    private String noteName;
    private String texts;
    private String img;
    private String url;
    private final FileOperations file = new FileOperations();

    // Open the text file where the data for the corresponding note is stored and assign each variable with the correct
    // content.
    public Note(String name) {

        this.noteName = name;
        Scanner reader = file.openFile(noteName);
        this.noteName = reader.nextLine();
        this.img = reader.nextLine();
        this.url = reader.nextLine();
        this.texts = "";
        while (reader.hasNextLine()) {
            this.texts += reader.nextLine();
        }
        reader.close();
    }


    public String getName() {

        return noteName;
    }

    public String getText() {

        return texts;

    }

    public String getImage() {

        return img;
    }

    public String getUrl() {

        return url;
    }

    public void setName(String name) {

        noteName = name;
    }

    public void setText(String text) {

        texts = text;
    }

    public void setImage(String image) {

        img = image;

    }

    public void setUrl(String url1) {

        url = url1;

    }

}

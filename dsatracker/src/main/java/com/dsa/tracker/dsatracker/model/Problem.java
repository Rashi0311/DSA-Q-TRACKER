package com.dsa.tracker.dsatracker.model;

// Required imports for MongoDB document and ID annotations
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// This class will be stored as a MongoDB collection named "problems"
@Document(collection = "problems")
public class Problem {

    // MongoDB will automatically use this field as the unique _id
    @Id
    private String id;

    private String link;
    private String notes; // Add this line


    // Title of the DSA problem (e.g., "Two Sum")
    private String title;

    // Difficulty level (e.g., "Easy", "Medium", "Hard")
    private String difficulty;

    // Whether the user has solved this problem or not (true/false)
    private boolean solved;

    // Default constructor (needed by Spring and MongoDB)
    public Problem() {
    }

    // Parameterized constructor — useful when creating objects manually
    public Problem(String title, String difficulty, boolean solved) {
        this.title = title;
        this.difficulty = difficulty;
        this.solved = solved;
    }

    // Getter for MongoDB ID
    public String getId() {
        return id;
    }

    // Getter and Setter for Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for Difficulty
    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    // Getter and Setter for Solved
    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}

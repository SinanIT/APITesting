package pojos;
/*
POJO: Plan old java objects
Pojo is a java class

to create pojo class we need five STEPS
    1- create private variables
    2- create getters and setters
    3- create constructor without parmater
    4- create constructor with all parameters
    5- cretae toString


 */

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TodosPojo {
    // variables
    private int userId;
    private String title;
    private boolean completed;

    //getter setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    //create both constructors
    TodosPojo(){}

    public TodosPojo(int userId, String title, boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TodosPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}

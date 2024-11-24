import org.w3c.dom.stylesheets.MediaList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class User {
    UserIO UserIO = new UserIO();
    TextUI ui = new TextUI();
    private String name;
    private int age;
    private String password;
    private String username;
    private List<Media> movieList;
    private List<Media> seriesList;
    private boolean adult = true;
    //private HashMap<String, String> userCredentials;
    private String path = "data\\userdata.txt";

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.movieList = new ArrayList<Media>();
        this.seriesList = new ArrayList<Media>();
    }

    /*public void createUser(){
        setUsername();
        setPassword();
        //userCredentials.put(this.username, this.password); flex only
        ui.displayMsg("You have successfully created a user and are now logged in");
        ArrayList<String> savedData = new ArrayList<>();
        savedData.add(this.username);
        savedData.add(this.password);
        io.saveData(savedData, USER, "username, password");
    }*/

    public void login(){
        String loginUsername = ui.promptText("Please enter your username");
        if(!this.path.contains(loginUsername)){
            String loginPassword = ui.promptText("Please enter your password");
        }
        String loginPassword = ui.promptText("Please enter your password");
        //if();
    }

    public void setAge(int age) {
        age = ui.promptNumeric("Please enter your age: ");
        if(age <= 0) {
            throw new IllegalArgumentException("Age must be a number above 0");
        }else {
            this.age = age;
        }
        if(age <= 12){
            adult = false;
        }
        //her kan indsættes yderlige kode til at skelne mellem voksen og barn
    }

    public void setName(String name) {
        name = ui.promptText("Please enter your name: ");
        if(name == null || name.equals("")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        else {
            this.name = name;
        }
    }

    public void setPassword() {
        password = ui.promptText("Please enter your password: ");
        if(password == null || password.equals("")){
            throw new IllegalArgumentException("Password cannot be empty");
        }
        else {
            this.password = password;
        }
    }

    public void setUsername() {
        username = ui.promptText("Please enter your username: ");
        if(username == null || username.equals("")){
            throw new IllegalArgumentException("Username cannot be empty");
        }
        else {
            this.username = username;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Username: " + username + " Password: " + password;
    }
}

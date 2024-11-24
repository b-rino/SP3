import org.w3c.dom.stylesheets.MediaList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;

public class User {
    FileIO io = new FileIO();
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

    public User() {
        this.movieList = new ArrayList<Media>();
        this.seriesList = new ArrayList<Media>();
        //this.userCredentials = new HashMap<>();
    }

    public void createUser() {
        setUsername();
        setPassword();
        //userCredentials.put(this.username, this.password); flex only
        //String succesLogin = ui.promptText("You have successfully created a user and are now logged in");
        JOptionPane.showMessageDialog(null, "You have successfully created a user and are now logged in");
        ArrayList<String> savedData = new ArrayList<>();
        savedData.add(this.username);
        savedData.add(this.password);
        io.saveData(savedData,this.path,"Username,Password");
        //todo: Få SaveData til at virke - jeg har spurgt chat og den siger det burde virke
        // jeg har kørt debud på den også og der skulle ikke være nogen fejl?
    }

    public void login() {
        String loginUsername = JOptionPane.showInputDialog(" Please enter username: ");
        JOptionPane.showMessageDialog(null, "Welcome " + loginUsername);
        //String loginUsername = ui.promptText("Please enter your username");
        if (!this.path.contains(loginUsername)) {
            //String loginPassword = ui.promptText("Please enter your password");
            String loginPassWord = JOptionPane.showInputDialog(" Please enter your password: ");
            JOptionPane.showMessageDialog(null, "You have successfully logged in");
        }
    }

    public void setAge(int age) {
        age = ui.promptNumeric("Please enter your age: ");
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a number above 0");
        } else {
            this.age = age;
        }
        if (age <= 12) {
            adult = false;
        }
        //her kan indsættes yderlige kode til at skelne mellem voksen og barn
    }

    public void setName(String name) {
        name = ui.promptText("Please enter your name: ");
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    public void setPassword() {
        /* kan ikke få "frame" til at gå væk efter man har tastet password
        JFrame passwordFrame = new JFrame("Eksempel for password");
        JPasswordField passwordField = new JPasswordField();
        JLabel passwordLabel = new JLabel("Password");
        passwordFrame.setBounds(20, 100, 80, 30);
        passwordField.setBounds(100, 100, 100, 30);
        passwordFrame.add(passwordLabel);
        passwordFrame.add(passwordField);
        passwordFrame.setSize(300, 300);
        passwordFrame.setLayout(null);
        passwordFrame.setVisible(true);

        JFrame frame = new JFrame("Password window");
        JButton login = new JButton("Login");
        login.setBounds(50, 50, 100, 30);
        frame.add(login);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        */
        password = JOptionPane.showInputDialog("Please enter your password: ");
        JOptionPane.showMessageDialog(null, "Your password is Valid");
        if(password == null || password.equals("")){
          throw new IllegalArgumentException("Password cannot be empty");
        }

    }

    public void setUsername() {
        /*
        JFrame userNameFrame = new JFrame("Eksempel for username");
        JPasswordField userNameField = new JPasswordField();
        JLabel Label = new JLabel("Username");
        userNameFrame.setBounds(20, 100, 80, 30);
        userNameField.setBounds(100, 100, 100, 30);
        userNameFrame.add(userNameField);
        userNameFrame.add(userNameField);
        userNameFrame.setSize(300, 300);
        userNameFrame.setLayout(null);
        userNameFrame.setVisible(true);
        */

        username = JOptionPane.showInputDialog("Please enter your username: ");
        JOptionPane.showMessageDialog(null, "Username is ok");
        if(username == null || username.equals("")){
            JOptionPane.showMessageDialog(null, "Username cannot be empty");
            //JOptionPane.showMessageDialog(null, "Please enter a valid username");
            throw new IllegalArgumentException("Username cannot be empty");
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

}
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class User extends Chat implements Serializable {

    private String name;
    private String password;
    private String bio;
    private int id;
    private String avatarSrc;
    private String dir;
    private String fileDir;
    private String messageDir;
    private String email;
    private String cmd;
    private ArrayList<Integer> messages = new ArrayList<Integer>();

    public User(String email,String name, String password,int id,String mainDir,String bio,String avatarSrc) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.id = id;
        if (bio != null) {
            this.bio = bio;
        } else {
            this.bio = "Basic personal info";
        }
        if (avatarSrc != null) {
            this.avatarSrc = avatarSrc;
        } else {
            this.avatarSrc = "resources\\avatar.png";
        }
        this.dir = mainDir + File.separator + "users" + File.separator + id;
        fileDir = this.dir + File.separator + "files";
        messageDir = this.dir + File.separator + "messages";

        try {
            Files.createDirectories(Paths.get(dir));
        }catch (IOException e){
            System.out.println("In User.Constructor() error occurred: "+ e.getMessage());
        }
        save();
    }

    public User(String email,String name, String password, String bio, String avatarSrc) {
        this.name = name;
        this.password = password;
        this.bio = bio;
        this.avatarSrc = avatarSrc;
        this.email = email;
    }

    void save(){
        //System.out.print("Saving user info ... ");
        try {
            FileOutputStream file = new FileOutputStream(dir+ File.separator + "info");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(this);
            output.close();
            //System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println("In User.save() error occurred: "+ e.getMessage());
        }
    }

    //-------------------Getters and setters--------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getAvatarSrc() {
        return avatarSrc;
    }

    public void setAvatarSrc(String avatarSrc) {
        this.avatarSrc = avatarSrc;
    }
    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    public String getMessageDir() {
        return messageDir;
    }

    public void setMessageDir(String messageDir) {
        this.messageDir = messageDir;
    }

    public static void main(String[] args){
       // User user = new User("jan","pass",1,)
    }
    int nextMessageId(){
        return Functions.nextId(messages);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
}

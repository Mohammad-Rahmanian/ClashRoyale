package Model;

import java.io.Serializable;

public class PlayerProfile implements Serializable {
    private String userName;
    private String password;

    public PlayerProfile(String userName,String password){
        this.userName = userName;
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

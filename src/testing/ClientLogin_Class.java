package testing;

public class ClientLogin_Class {
    String user_name ="client";
    String pass= "client111";

    public boolean userLogin(String username, String password) {
        boolean result = false;

        if(username == user_name && password == pass) {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {


    }
}

package testing;

public class AdminLogin_Class {
    String user_name ="dipesh__siwakoti";
 String pass= "dipesh111";

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

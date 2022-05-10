package client.model;

public class ModelManager implements Model{

    public boolean login(String username, String password){
        if(username.equals("aaaaa") && password.equals("aaaaa")){
            return true;
        }
        return false;
    }
}

package Doa.DaoImp;

import Controller.User.Role;
import Doa.UserValidatedDao;

import java.io.*;

public class UserValidatedImp implements UserValidatedDao {

    private String userName;
    private String password;
    private Role role;
    private final static String path="src/main/resources/users";
    File file = new File(path);

    public UserValidatedImp(String userName,String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean isValid() {
        String line="";
        BufferedReader bufferedReader= null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));

            while (((line = bufferedReader.readLine()) != null)) {

                String[] data = line.split(",");
                if (data[0].equals(userName) && data[1].equals(password)) {
                    return true;
                }
            }} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isAdmin()  {
        return checkForRole(this.userName);
    }

    private boolean checkForRole(String userName)  {
        String line="";
        BufferedReader bufferedReader= null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));

            while (((line = bufferedReader.readLine()) != null)) {

                String[] data = line.split(",");
                if (data[0].equals(userName) && data[2].equals(String.valueOf(Role.ADMINISTRATOR))) {
                    this.role= Role.valueOf(data[2]);
                    return true;
                }
            }} catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isDefaultAdmin() {
        boolean isDefault=false;
        if(userName.equals("root")&&password.equals("")){
            isDefault=true;
        }
        return isDefault;
    }

}

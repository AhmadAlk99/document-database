package Doa.DaoImp;

import Controller.User.Role;
import Doa.DefaultAdminDao;

import java.io.*;
import java.nio.file.Files;
import java.util.concurrent.locks.Lock;

public class DefaultAdminImp implements DefaultAdminDao {

    private String adminName;
    private String password;
    private Role role = Role.ADMINISTRATOR;
    private final static String path = "src/main/resources/users";
    File newFile = new File(path + "Copy.txt");

    final static String pathToDatabse = "src/main/resources/DataBases";

    File file = new File(path);

    public DefaultAdminImp(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }

    @Override
    public boolean createAdmin() {
        synchronized (this) {
            String admin = toString();
            boolean added = checkForAdmin(adminName);
            if (!added) {
                try (FileWriter fileWriter = new FileWriter(file, true)) {

                    fileWriter.write(admin);
                    added = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return !added;
        }
    }

    public boolean checkForAdmin(String userName) {
        synchronized (this) {
            String line = "";

            BufferedReader bufferedReader = null;

            try {
                bufferedReader = new BufferedReader(new FileReader(file));

                while (((line = bufferedReader.readLine()) != null)) {

                    String[] data = line.split(",");
                    if (data[0].equals(userName) && data[2].equals("ADMINISTRATOR")) {
                        return true;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

    }

    @Override
    public Boolean updateAdminName(String name) {
        synchronized (this) {
            String line;
            boolean updated = false;

            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                FileWriter newFileWriter = new FileWriter(newFile)) {


                while ((line = bufferedReader.readLine()) != null) {
                    String[] data = line.split(",");

                    if (adminName.equals(data[0])) {
                        this.adminName = name;
                        newFileWriter.write(toString() + "\n");
                        updated = true;
                    } else {
                        newFileWriter.write(line + "\n");
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                copyContent(newFile, file);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            return updated;
        }
    }
    @Override
    public Boolean updateAdminPassword(String password) {
        synchronized (this) {
            String line;
            boolean updated = false;
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                FileWriter newFileWriter = new FileWriter(newFile);) {


                while ((line = bufferedReader.readLine()) != null) {
                    String[] data = line.split(",");

                    if (this.password.equals(data[1])) {
                        this.password = password;
                        newFileWriter.write(toString() + "\n");
                        updated = true;
                    } else {
                        newFileWriter.write(line + "\n");
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                copyContent(newFile, file);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return updated;
        }
    }

    private void copyContent(File newFile,File file)  {
        try {
            Files.delete(file.toPath());
            newFile.renameTo(file);
        } catch (Exception e){
            System.out.println("not found");;
        }
    }

    @Override
    public String toString() {
        return adminName + ',' + password + ',' + role+"\n";
    }

}

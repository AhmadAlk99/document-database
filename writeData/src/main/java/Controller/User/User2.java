package Controller.User;

public class User2 {

    String username;
    String salt;
    String password;
    Role role;

    @Override
    public String toString() {
        return username + "," + password + ","
                + salt + "," + role.toString() +"\n";
    }

    private User2(UserBuilder builder){
        this.username=builder.username;
        this.password=builder.password;
        this.salt=builder.salt;
        this.role=builder.role;
    }

    public static class UserBuilder {

        private String username;
        private String password;
        private String salt;
        private Role role;
        private boolean isEnabled;


        public UserBuilder username (String username){
            this.username=username;
            return this;
        }

        public UserBuilder password (String password){
            this.password=password;
            return this;
        }

        public UserBuilder salt (String salt){
            this.salt=salt;
            return this;
        }

        public UserBuilder role (Role role){
            this.role=role;
            return this;
        }

        public UserBuilder isEnabled (Boolean isEnabled){
            this.isEnabled=isEnabled;
            return this;
        }


        public  User2 build(){
            return new User2(this);
        }

    }

    public Role getRole() { return role; }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
package Controller.User;

public class User {

    String username;
    String password;
    Role role;

    @Override
    public String toString() {
        return  username + "," + password + ","
                + role.toString() +"\n";
    }

    private User(UserBuilder builder){
        this.username=builder.username;
        this.password=builder.password;
        this.role=builder.role;
    }

    public static class UserBuilder {

        private String username;
        private String password;
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

        public UserBuilder role (Role role){
            this.role=role;
            return this;
        }

        public UserBuilder isEnabled (Boolean isEnabled){
            this.isEnabled=isEnabled;
            return this;
        }

        public  User build(){
            return new User(this);
        }

    }

    public Role getRole() { return role; }

    public void setRole(Role role) {
        this.role = role;
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

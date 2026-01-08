public class User {
    private String email;
    private String password;

    String emailPattern = "^[\\w.]+@[\\w]+\\.[a-zA-z]{2,}$";
    String passwordPattern = "[\\w\\W\\s]{8,}";

    public void setEmail(String email) {
        if (email == null || !email.matches(emailPattern)){
            System.out.println("enter valid email");
        }else{
            this.email = email;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        if (password == null || !email.matches(passwordPattern)){
            System.out.println("enter valid password");
        }else{
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }

    static void main() {
        String email = "bibekbaram.b@gmail.com";
        String password = "baram123";

        User u = new User();
        u.setEmail(email);
        u.setPassword(password);

        System.out.println("Email : "+u.getEmail());
        System.out.println("password : "+u.getPassword());
    }
}

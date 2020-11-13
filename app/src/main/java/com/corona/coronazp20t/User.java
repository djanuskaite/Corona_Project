package com.corona.coronazp20t;
//public, nes kitaip mes protectedd

public class User {
    //1. objektu kintamieji (pozymiai, argumentai)
    private String username;
    private String password;
    private String email;
    //2. konstruktorius
    // des.kl. -> generate -> constructor
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    //3. CLASS METHODS - get & set
    // des. kl. -> generate -> getter and setter

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

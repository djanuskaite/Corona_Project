package com.corona.coronazp20t;
//public, nes kitaip mes protectedd

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    //1. objektu kintamieji (pozymiai, argumentai)
    private String username;
    private String password;
    private String email;
// shared pref - privatus duomenis prie prisijungimo aplikacijos
    private SharedPreferences sharedPreferences; // private matomi klases ribose TIK
    private static final String PREFERENCES_PACKAGE_NAME="com.corona.coronazp20t";
    private static final String USERNAME_KEY="username"; // static final - reiksme nekis
    private static final String PASSWORD_KEY="password"; // su static nereikia kurtis objekto
    private static final String REMEMBER_KEY="rememberMe";


    //2. konstruktorius skirtas naujo vartotojo registracijai
    // des.kl. -> generate -> constructor
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //konstruktorius vartotojo prisijungimui
    public User(Context context){ // sukuriam "faila" kur saugosim duomenis
        this.sharedPreferences = context.getSharedPreferences(User.PREFERENCES_PACKAGE_NAME,
                Context.MODE_PRIVATE);
    }
    //3. CLASS METHODS - get & set
    // des. kl. -> generate -> getter and setter


    //set & get eina prie pozymiu

    public String getUsernameForRegistration() {
        return username;
    }
    public String getPasswordForRegistration() {
        return password;
    }
    public String getEmailForRegistration() {
        return email;
    }

    public void setUsernameForRegistration(String username) {
        this.username = username;
    }

    public void setPasswordForRegistration(String password) {
        this.password = password;
    }

    public void setEmailForRegistration(String email) {
        this.email = email;
    }

    public String getUsernameForLogin() {
        return this.sharedPreferences.getString(USERNAME_KEY, "");
    }
    public void setUsernameForLogin(String username) {
        this.sharedPreferences.edit().putString(USERNAME_KEY, username).commit(); // commit - pakeitimu issaugojimui
    }

    public String getPasswordForLogin() {
        return this.sharedPreferences.getString(PASSWORD_KEY, "");
    }
    public void setPasswordForLogin(String password) {
        this.sharedPreferences.edit().putString(PASSWORD_KEY, password).commit();
    }

    public boolean isRememberedForLogin() {
        return this.sharedPreferences.getBoolean(REMEMBER_KEY, false); // checkbox yra boolean
    }
    public void setRememberKeyForLogin(boolean rememberKey) {
        this.sharedPreferences.edit().putBoolean(REMEMBER_KEY, rememberKey).commit();
    }

}

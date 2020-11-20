package com.corona.coronazp20t;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    EditText usernametext, passwordtext;
    Button loginbutton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // on create - veikasmas vyksta kai krauna langa
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //visas kodas rasomas po sito komentaro

        Button loginbutton = (Button) findViewById(R.id.loginbutton);
        //cia istraukiamas elementas is vaizdo

        final EditText usernametext = (EditText) findViewById(R.id.usernametext); // final kai nekinta
        //edit text yra neapdirbtas formatas, todel isvedant reikia rasyti getText toString
        final EditText passwordtext = (EditText) findViewById(R.id.passwordtext);



        final CheckBox rememberMe = (CheckBox) findViewById(R.id.rememberMe);
        // konstruojamos vartotojo objektasp perduodant  context (langa, kuriame esam)
        final User user = new User(LoginActivity.this);
        // patikriname ar paskutini karta buvo pazymetas checkboxas
        rememberMe.setChecked(user.isRememberedForLogin());

        // aprasoma ''prisiminti mane'' checkboxo logika
        if (rememberMe.isChecked()){   // jei checkboxas buvo pazymetas
            usernametext.setText(user.getUsernameForLogin(), TextView.BufferType.EDITABLE); //settext uzpildysim user informacija, editable suteiksim galimybe redaguoti
            passwordtext.setText(user.getPasswordForLogin(), TextView.BufferType.EDITABLE);
        } else { // jeigu checkbox buvo nepazymetas - vartotojas nenorejo, kad info butu issaugota
            usernametext.setText("", TextView.BufferType.EDITABLE);
            passwordtext.setText("", TextView.BufferType.EDITABLE);
        }


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cia bus vykdomas kodas po button paspausdimo

                if (!Validation.isValidUsername(usernametext.getText().toString())) {
                    usernametext.setError(getResources().getString(R.string.login_invalid_username));
                    usernametext.requestFocus();
                }
                if (!Validation.isValidPassword(passwordtext.getText().toString())) {
                    passwordtext.setError(getResources().getString(R.string.login_invalid_username));
                    passwordtext.requestFocus();
                }
                else {
                    user.setUsernameForLogin(usernametext.getText().toString());
                    user.setPasswordForLogin(passwordtext.getText().toString());
                    if (rememberMe.isChecked()) {
                        user.setRememberKeyForLogin(true);
                    } else {
                        user.setRememberKeyForLogin(false);
                    }


                    Intent goToSearchActivity = new Intent(LoginActivity.this,
                            SearchActivity.class);
                    startActivity(goToSearchActivity);

                    Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_success),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity();
            }
        });

    }


    public void RegisterActivity() {
        Intent goRegisterActivity = new Intent(LoginActivity.this,
                RegisterActivity.class);
        startActivity(goRegisterActivity);
    }

}

package com.example.adria.register;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//Sign up Activity class
public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    EditText Email, Password;
    private FirebaseAuth mAuth;

    //Find what the user put as email and password
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.Signup).setOnClickListener(this);

    }
    //set Password and email to string
    private void registerUser(){
        String E = Email.getText().toString().trim();
        String P = Password.getText().toString().trim();

        //if email is empty then give error
        if(E.isEmpty()){
            Email.setError("Email is required");
            Email.requestFocus();
            return;
        }

        //if email is not an email format give error
        if(!Patterns.EMAIL_ADDRESS.matcher(E).matches()){
            Email.setError("Please enter a valid email");
            Email.requestFocus();
            return;
        }
        //if password is empty then give error
        if(P.isEmpty()){
            Password.setError("Password is required");
            Password.requestFocus();
            return;
        }
        //if password is less then 6 characters, give error.
        if(P.length()< 6){
            Password.setError("Minimum Password length has to be 6 or more characters");
            Password.requestFocus();
            return;
        }
        //Calls the firebase method to create a new user.
        mAuth.createUserWithEmailAndPassword(E, P).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
             if(task.isSuccessful()){
                 Toast.makeText(getApplicationContext(),"User register Sucessfully",Toast.LENGTH_SHORT).show();
             }
            }
        });
    }
    //register user when sign up button is clicked
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Signup:

                registerUser();

                break;
        }
    }
}

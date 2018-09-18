package com.example.adria.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Register extends AppCompatActivity implements OnClickListener  {

    //Starts the App on the login Page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        findViewById(R.id.Pleasesignup).setOnClickListener(this);
    }
    //Logs where the user clicks if user clicks on sign up then go to sign up page
    @Override
    public void onClick(View view) {
    switch(view.getId()){
        case R.id.Pleasesignup:

            startActivity(new Intent(this,SignupActivity.class));

            break;
    }
    }


}

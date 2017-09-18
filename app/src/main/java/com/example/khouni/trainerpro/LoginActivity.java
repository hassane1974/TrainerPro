package com.example.khouni.trainerpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText Username;
    private EditText Password;
    private Button Login;
    private TextView Info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Username = (EditText)findViewById(R.id.Userlog);
        Password = (EditText)findViewById(R.id.PassedT);
        Login = (Button)findViewById(R.id.LoginBt);
        Info = (TextView)findViewById(R.id.FailedLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vallogin(Username.getText().toString(),Password.getText().toString());
            }
        });
    }


    private void vallogin (String UserName,  String uPassword){

        if (UserName.equals("JDOE")&& uPassword.equals("welcome1")) {

            Intent intent = new Intent(LoginActivity.this , ListClients.class);
            startActivity(intent);
            Info.setText("Login successfully");
        }
        else{

            Info.setText("Login failed try again");
        }
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fragment_user_login, menu);
        return true;
    }
    */
}


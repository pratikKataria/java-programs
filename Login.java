package com.example.dearproblems;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText email_et;
    EditText password_et;
    Button login_btn;
    FirebaseAuth mAuth;

    public void initializeFields() {
        email_et      = findViewById(R.id.email_et);
        password_et   = findViewById(R.id.pass_et);
        login_btn  = findViewById(R.id.login_btn);
        mAuth = FirebaseAuth.getInstance();

        login_btn.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeFields();
        changeStatusBarColor();
   }

    public void checkUserInput() {
        String email = email_et.getText().toString();
        String pass  = password_et.getText().toString();

        if (email.isEmpty()) {
            email_et.setError("email required");
            email_et.requestFocus();
            return ;
        }

        if (pass.isEmpty()) {
            password_et.setError("pass required");
            password_et.requestFocus();
            return ;
        }

        signIn();

    }

    @Override
    public void onClick(View v) {
        checkUserInput();
    }

   public void signIn() {
       String email = email_et.getText().toString();
        String pass  = password_et.getText().toString();
                mAuth.signInWithEmailAndPassword(email, pass)
                       .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()) {
                                   Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                   new Intent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                   startActivity( new Intent(Login.this, Profile.class));
                               } else
                                   Toast.makeText(Login.this, "Login error", Toast.LENGTH_SHORT).show();
                           }
                       });
    }


    private void changeStatusBarColor() {
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryRed));
    }

}

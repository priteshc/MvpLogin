package com.example.pritesh.mymvp;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pritesh.mymvp.Interface.LoginView;
import com.example.pritesh.mymvp.Presenter.LoginPresenter;


public class MainActivity extends AppCompatActivity implements LoginView {

    EditText user,pass;

    Button sub;

    private LoginPresenter loginPresenter;
    private Context context = MainActivity.this;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user = (EditText) findViewById(R.id.user);

        pass = (EditText) findViewById(R.id.pass1);

        sub = (Button) findViewById(R.id.sub);


        dialog = new ProgressDialog(context);


        loginPresenter = new LoginPresenter(this);


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                loginPresenter.DoLogin(user.getText().toString(),pass.getText().toString());


            }
        });



    }

    @Override
    public void showErrorMeassageUserNamePassword() {

        Toast.makeText(context,"Error",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showMaxAttemptLogin() {

        Toast.makeText(context,"Exxced attempt",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void showLoginSuccessMsg() {

        Toast.makeText(context,"success",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void showprogress() {

        dialog.show();
    }

    @Override
    public void hideprogress() {

        dialog.hide();

    }
}

package com.example.assia.lostandfound;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] login={"assia", "ludvig", "hamza"};
    private static final String[] pass={"lol", "bra", "aloha"};





    // UI references.
    public EditText mEmailView;
    public EditText mPasswordView;
    public Button mEmailSignInButton;
    public Button signInBtnForgottenPass;
    public Button signUpBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        signInBtnForgottenPass = (Button) findViewById(R.id.signInBtnForgottenPass);
        signUpBtn = (Button) findViewById(R.id.signUpBtn);
        MyClickListener t = new MyClickListener();
        mEmailSignInButton.setOnClickListener(t);
        signInBtnForgottenPass.setOnClickListener(t);
        signUpBtn.setOnClickListener(t);


    }

    //click listener
    class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v){

            String passInput =mPasswordView.getText().toString();
            String loginInput =mEmailView.getText().toString();

            switch (v.getId())
            {
                case R.id.email_sign_in_button:

                    for (int i=0; i<login.length;i++){

                        if(login[i].equals(loginInput) && pass[i].equals(passInput))
                        {
                            String text = "Welcome!";
                            Toast t = Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT);

                            t.show();
                            setContentView(R.layout.activity_lost_found_menu);
                            break;
                        }
                        else {
                            if(i==login.length-1){

                                String text = "Email and/or Password are incorrect, try again!";
                                Toast t = Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT);

                                t.show();
                                break;
                            }
                        }
                    }

                    break;
                case R.id.signUpBtn:
                    setContentView(R.layout.activity_sign_up);
                    break;
                case R.id.signInBtnForgottenPass:
                    setContentView(R.layout.activity_forgotten_password);
                    break;
            }



        }
    }
}

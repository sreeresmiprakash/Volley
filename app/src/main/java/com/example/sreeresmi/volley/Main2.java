package com.example.sreeresmi.volley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2 extends AppCompatActivity {
    TextView txtname,txtnum;
    private Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        session = new Session(this);
        if(!session.loggedin()){
            session.setLoggedin(false);
            startActivity(new Intent(Main2.this,MainActivity.class));
            finish();
        }



        Intent intent= getIntent();
        String username=intent.getStringExtra("username");
        String mobile=intent.getStringExtra("mobile");

        txtname=(TextView)findViewById(R.id.txt_name);
        txtnum=(TextView)findViewById(R.id.txt_num);

        txtname.setText(username);
        txtnum.setText(mobile);
    }

    public void logout(View view){
        session.setLoggedin(false);
        startActivity(new Intent(Main2.this,MainActivity.class));
        finish();

    }
}

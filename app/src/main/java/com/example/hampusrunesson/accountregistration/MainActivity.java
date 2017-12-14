package com.example.hampusrunesson.accountregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;

public class MainActivity extends AppCompatActivity {

    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        account = findViewById(R.id.accountRegistration);

        account.addField("Favorite food", InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT, false);
        account.addField("Job",InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD, true);

        Tester t = new Tester();
    }

}

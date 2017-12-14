package com.example.hampusrunesson.accountregistration;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.renderscript.ScriptGroup;
import android.renderscript.Type;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;

/**
 * Created by hampusrunesson on 12/12/17.
 */

public class Account extends LinearLayout {

    private Context context;
    private AccRequirements accReq;
    private LinearLayout layout;
    private ArrayList<EditText> requiredFields = new ArrayList<>();
    private ArrayList<EditText> notRequiredFields = new ArrayList<>();

    private ArrayList<EditText> defaultFields = new ArrayList<>();

    //name
    private EditText nameField;
    //username
    private EditText userField;
    //email
    private EditText emailField;
    //age
    private EditText ageField;
    //pw
    private EditText pwField;
    //sign up button
    private Button signBtn;

    public Account(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        accReq = new AccRequirements();
        layout = (LinearLayout) inflate(context, R.layout.account_registration, null);
        setOrientation(VERTICAL);

        //name
        nameField = layout.findViewById(R.id.nameField);
        defaultFields.add(nameField);
        //username
        userField = layout.findViewById(R.id.usernameField);
        defaultFields.add(userField);
        //email
        emailField = layout.findViewById(R.id.emailField);
        defaultFields.add(emailField);
        //age
        ageField = layout.findViewById(R.id.ageField);
        defaultFields.add(ageField);
        //pw
        pwField = layout.findViewById(R.id.pwField);
        defaultFields.add(pwField);
        //sign up button
        signBtn = layout.findViewById(R.id.button);

        addView(layout);

        signBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                nameField.setBackgroundColor(accReq.nameValid(nameField.getText().toString()));
                userField.setBackgroundColor(accReq.userValid(userField.getText().toString()));
                emailField.setBackgroundColor(accReq.emailValid(emailField.getText().toString()));
                ageField.setBackgroundColor(accReq.ageValid(ageField.getText().toString()));
                pwField.setBackgroundColor(accReq.pwValid(pwField.getText().toString()));

                    for(EditText e: requiredFields)
                    {
                        e.setBackgroundColor(accReq.newCompValid(e.getText().toString()));
                    }

                    for(EditText n: notRequiredFields)
                    {
                        n.setBackgroundColor(Color.GREEN);
                    }

                if(accReq.validAccount())
                {
                    Toast success = Toast.makeText(context, "You account was made successfully! :) ", Toast.LENGTH_LONG);
                    success.setGravity(Gravity.CENTER, 0, -200);
                    ViewGroup g = (ViewGroup) success.getView();
                    TextView v = (TextView) g.getChildAt(0);
                    v.setTextSize(20);
                    success.show();

                    for(EditText e: defaultFields)
                    {
                        e.setText("");
                        e.setBackgroundColor(Color.parseColor("#99b7ce"));
                    }

                    for(EditText e: requiredFields)
                    {
                        e.setText("");
                        e.setBackgroundColor(Color.parseColor("#99b7ce"));
                    }

                    for(EditText n: notRequiredFields)
                    {
                        n.setText("");
                        n.setBackgroundColor(Color.parseColor("#99b7ce"));
                    }

                }
                else
                {
                    Toast fail = Toast.makeText(context, "Account registration was unsuccessful,\ncheck the field(s) marked as read", Toast.LENGTH_LONG);
                    fail.setGravity(Gravity.CENTER, 0, -200);
                    ViewGroup g = (ViewGroup) fail.getView();
                    TextView v = (TextView) g.getChildAt(0);
                    v.setTextSize(20);
                    fail.show();
                }
            }
        });
    }

    public void addField(String title, int inputType, Boolean required)
    {
        if(!title.contains(":"))
        {
            title += ":";
        }

        LinearLayout newLayout = (LinearLayout) inflate(context, R.layout.addcomponent, null);

        EditText editText = newLayout.findViewById(R.id.newText);
        TextView textView = newLayout.findViewById(R.id.newTitle);

        if(required)
            requiredFields.add(editText);
        else
            notRequiredFields.add(editText);

        editText.setInputType(inputType);

        textView.setText(title);

        ((ViewGroup) signBtn.getParent()).removeView(signBtn);
        addView(newLayout);
        addView(signBtn);
    }
}

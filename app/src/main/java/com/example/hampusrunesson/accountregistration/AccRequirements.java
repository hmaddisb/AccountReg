package com.example.hampusrunesson.accountregistration;

import android.graphics.Color;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by hampusrunesson on 12/12/17.
 */

public class AccRequirements implements AccInterface{

    private ArrayList<Boolean> validation = new ArrayList<>();


    @Override
    public int nameValid(String name) {

        if(name.contains(" ")) {
            String firstN = name.split(" ")[0];
            String lastN = name.split(" ")[1];
            if(firstN.charAt(0) == firstN.toUpperCase().charAt(0) && lastN.charAt(0) == lastN.toUpperCase().charAt(0))
            {
                if(!firstN.matches(".*\\d+.*") && !lastN.matches(".*\\d+.*"))
                {
                    validation.add(true);
                    return Color.GREEN;
                }
            }
        }
        validation.add(false);
        return Color.RED;
    }

    @Override
    public int userValid(String username) {

        if(username.equals("username") || username.equals("hamru") || username.equals("maddis") || username.length() <= 1)
        {
            validation.add(false);
            return Color.RED;
        }
        validation.add(true);
        return Color.GREEN;
    }

    @Override
    public int emailValid(String email) {

        if(email.contains("@"))
        {
            String emailDomain = email.split("@")[1];

            if(emailDomain.contains("."))
            {
                String countryCode = emailDomain.split("\\.")[1];

                if(countryCode.equals("com") || countryCode.equals("se"))
                {
                    validation.add(true);
                    return Color.GREEN;
                }
            }
        }
        validation.add(false);
        return Color.RED;
    }

    @Override
    public int ageValid(String age) {
        if(age.isEmpty() || age.length() <= 1 || age.length() >= 3) {
            validation.add(false);
            return Color.RED;
        }
        validation.add(true);
        return Color.GREEN;
    }

    @Override
    public int pwValid(String pw) {

        if(pw.matches(".*\\d+.*"))
        {
            if(!pw.equals(pw.toUpperCase()))
            {
                validation.add(true);
                return Color.GREEN;
            }

        }
        validation.add(false);
        return Color.RED;
    }

    @Override
    public int newCompValid(String line) {

        if(line.isEmpty())
        {
            validation.add(false);
            return Color.RED;
        }
        validation.add(true);
        return  Color.GREEN;

    }

    @Override
    public boolean validAccount() {

        if(validation.contains(false))
        {
            validation.clear();
            return false;
        }
        validation.clear();
        return true;
    }
}

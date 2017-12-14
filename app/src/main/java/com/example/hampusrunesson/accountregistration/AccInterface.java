package com.example.hampusrunesson.accountregistration;

import java.util.ArrayList;

/**
 * Created by hampusrunesson on 12/12/17.
 */

public interface AccInterface {

    int nameValid(String name);
    int userValid(String username);
    int emailValid(String email);
    int ageValid(String age);
    int pwValid(String pw);
    int newCompValid(String line);
    boolean validAccount();

}

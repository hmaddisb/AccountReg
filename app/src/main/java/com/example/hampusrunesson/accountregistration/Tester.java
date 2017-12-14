package com.example.hampusrunesson.accountregistration;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Maddis on 2017-12-13.
 */

public class Tester extends AccRequirements {
    @Override
    public int ageValid(String age) {

        if(age.equals("100"))
        {
            return Color.CYAN;
        }
        return super.ageValid(age);
    }
}

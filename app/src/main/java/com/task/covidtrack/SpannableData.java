package com.task.covidtrack;

import android.text.SpannableString;

public class SpannableData {

    String text;
    int color;
    int start;

    public SpannableData(String text, int color, int start) {
        this.text = text;
        this.color = color;
        this.start = start;
    }

    SpannableString spannableString=new SpannableString(text);

    public SpannableString getSpannableString() {
        
        return spannableString;
    }
}

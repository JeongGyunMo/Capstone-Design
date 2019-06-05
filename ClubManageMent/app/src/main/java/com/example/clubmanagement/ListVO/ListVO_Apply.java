package com.example.clubmanagement.ListVO;

import android.graphics.drawable.Drawable;

public class ListVO_Apply {
    public Drawable getApply_Img() {
        return Apply_Img;
    }

    public void setApply_Img(Drawable apply_Img) {
        Apply_Img = apply_Img;
    }

    public String getApply_name() {
        return Apply_name;
    }

    public void setApply_name(String apply_name) {
        Apply_name = apply_name;
    }

    public String getApply_major() {
        return Apply_major;
    }

    public void setApply_major(String apply_major) {
        Apply_major = apply_major;
    }

    private Drawable Apply_Img;
    private String Apply_name;
    private String Apply_major;
}

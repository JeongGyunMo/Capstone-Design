package com.example.clubmanagement.data;

import android.graphics.drawable.BitmapDrawable;

import com.example.clubmanagement.Database.ImageURL.Image_File;
import com.example.clubmanagement.Database.StudentData;
import com.example.clubmanagement.Fragment.Club_UserID;
import com.example.clubmanagement.Fragment.PageOneFragment;
import com.example.clubmanagement.data.model.LoggedInUser;
import com.example.clubmanagement.data.model.LoggedInUser;
import com.example.clubmanagement.login.LoginActivity;
import com.example.clubmanagement.login.SaveSharedPreference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    ArrayList<HashMap<String, String>> Student_Item_list;
    HashMap<String, String> Club_Item = new HashMap<String, String>();
    StudentData Std = new StudentData();
    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            Std.GetListData();
            Student_Item_list = Std.Student_Item_list;

            for (int i = 0; i < Student_Item_list.size(); i++) {
                Club_Item = Student_Item_list.get(i);
                String STUDENT_ID = Club_Item.get("STUDENT_ID");
                String PASSWORD= Club_Item.get("PASSWORD");
                if(STUDENT_ID.equals(username) && password.equals(PASSWORD)) {
                    Club_UserID.UserID = username;
                    LoggedInUser RealUser =
                            new LoggedInUser(
                                    java.util.UUID.randomUUID().toString(),
                                    STUDENT_ID);
                    return  new Result.Success<>(RealUser);
                }
            }
            return new Result.Error(new IOException("Error logging in"));
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
    public String Seed(String ID){
        return ID;
    }
}

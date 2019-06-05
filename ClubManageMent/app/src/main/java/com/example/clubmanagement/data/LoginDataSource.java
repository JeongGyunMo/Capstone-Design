package com.example.clubmanagement.data;

import com.example.clubmanagement.DATAPOOL.Student;
import com.example.clubmanagement.Database.StudentData;
import com.example.clubmanagement.DATAPOOL.Club_UserID;
import com.example.clubmanagement.data.model.LoggedInUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    public Result<LoggedInUser> login(String username, String password) {
        String StudentID[] = {"20145165","20145144","20163154","20145489","20151235","20186574","20171234","20169874"};
        String Password = "123456";
        try {
            // TODO: handle loggedInUser authentication
            for (int i = 0; i < 8; i++) {
                if(StudentID[i].equals(username) && Password.equals(password)) {
                    Club_UserID.UserID = username;
                    LoggedInUser RealUser =
                            new LoggedInUser(
                                    java.util.UUID.randomUUID().toString(),
                                    StudentID[i]);
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
}

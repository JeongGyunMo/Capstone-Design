package com.example.clubmanagement.DATAPOOL;

import com.example.clubmanagement.Database.ClubData;
import com.example.clubmanagement.Database.StudentData;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    public static ArrayList<HashMap<String, String>> Student_Item_list;

    public Student() {
        StudentData Student = new StudentData();
        Student.GetListData();
        Student_Item_list = Student.Student_Item_list;
    }
}

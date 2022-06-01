package com.example.iusu_app_v3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.iusu_app_v3.Activity.LogInActivity;
import com.example.iusu_app_v3.Models.Student;

public class SharedPreferenceManager {

    private static final String SHARED_PREF_NAME = "volleyregisterlogin";
    private static final String KEY_REG_NO = "keyregno";
    private static final String KEY_FIRST_NAME = "keyfirstname";
    private static final String KEY_LAST_NAME = "keylastname";
    private static final String KEY_GENDER = "keygender";
    private static final String KEY_FACULTY = "keyfaculty";
    private static final String KEY_CAMPUS = "keycampus";
    private static final String KEY_PHONE = "keyphone";
    private static final String KEY_EMAIL = "keyemail";

    private static SharedPreferenceManager mInstance;
    private static Context ctx;

    private SharedPreferenceManager(Context context) {
        ctx = context;
    }
    public static synchronized SharedPreferenceManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPreferenceManager(context);
        }
        return mInstance;
    }

    //this method will store the user data in shared preferences
    public void studentLogin(Student student) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_REG_NO, student.getRegNo());
        editor.putString(KEY_FIRST_NAME, student.getFirstName());
        editor.putString(KEY_LAST_NAME, student.getLastName());
        editor.putString(KEY_GENDER, student.getGender());
        editor.putString(KEY_FACULTY, student.getFaculty());
        editor.putString(KEY_CAMPUS, student.getCampus());
        editor.putString(KEY_PHONE, student.getPhone());
        editor.putString(KEY_EMAIL, student.getEmail());

        editor.apply();
    }

    //this method will checker whether student is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_REG_NO, null) != null;
    }

    //this method will give the logged in student
    public Student getStudent() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Student(
                sharedPreferences.getString(KEY_REG_NO, null),
                sharedPreferences.getString(KEY_FIRST_NAME, null),
                sharedPreferences.getString(KEY_LAST_NAME, null),
                sharedPreferences.getString(KEY_GENDER, null),
                sharedPreferences.getString(KEY_FACULTY, null),
                sharedPreferences.getString(KEY_CAMPUS, null),
                sharedPreferences.getString(KEY_PHONE, null),
                sharedPreferences.getString(KEY_EMAIL, null)

        );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        ctx.startActivity(new Intent(ctx, LogInActivity.class));
    }
}
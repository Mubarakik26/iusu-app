package com.example.iusu_app_v3.Activity;

import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.iusu_app_v3.R;
import com.example.iusu_app_v3.SharedPreferenceManager;
import com.example.iusu_app_v3.Models.Student;
import com.example.iusu_app_v3.URLs;
import com.example.iusu_app_v3.VolleySingleton;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class LogInActivity extends AppCompatActivity {


    TextInputLayout etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        getSupportActionBar().hide();

        if (SharedPreferenceManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }


        etEmail = findViewById(R.id.edit_text_email_log_in);
        etPassword = findViewById(R.id.edit_text_password_log_in);



        //calling the method userLogin() for login the user
        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentLogin();
            }
        });

        //if user presses on textview not register calling RegisterActivity
        findViewById(R.id.dont_have_account_sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });
    }

    private void studentLogin() {
        //first getting the values
        final String email = etEmail.getEditText().getText().toString();
        final String password = etPassword.getEditText().getText().toString();
        //validating inputs
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Please enter your email");
            etEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Please enter your password");
            etPassword.requestFocus();
            return;
        }

        //if everything is fine
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);

                            //if no error in response
                            if (!obj.getBoolean("error")) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                                Toast.makeText(getApplicationContext(), "creating new user object", Toast.LENGTH_SHORT).show();
                                //getting the user from the response
                                JSONObject userJson = obj.getJSONObject("student");

                                Toast.makeText(getApplicationContext(), "creating new user object", Toast.LENGTH_SHORT).show();

                                //creating a new student object
                                Student student = new Student(
                                        userJson.getString("reg_no"),
                                        userJson.getString("first_name"),
                                        userJson.getString("last_name"),
                                        userJson.getString("gender"),
                                        userJson.getString("faculty"),
                                        userJson.getString("campus"),
                                        userJson.getString("phone"),
                                        userJson.getString("email")
                                );

                                Toast.makeText(getApplicationContext(), "new user object created", Toast.LENGTH_SHORT).show();


                                //storing the user in shared preferences
                                SharedPreferenceManager.getInstance(getApplicationContext()).studentLogin(student);
                                Toast.makeText(getApplicationContext(), "new user object stored and opening new activity", Toast.LENGTH_SHORT).show();


                                finish();

                                Toast.makeText(getApplicationContext(), "still working", Toast.LENGTH_SHORT).show();

                                //starting the profile activity
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();


                            } else {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}
package com.example.iusu_app_v3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
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

public class SignUpActivity extends AppCompatActivity {

    String[] genderItems,facultyItems,campusItems;
    TextInputLayout editTextRegno, editTextFirstName, editTextLastName,editTextGenderLayout,editTextFacultyLayout,editTextCampusLayout,editTextPhone,editTextEmail,editTextPassword,editTextConfirmPassword;
    AutoCompleteTextView editTextGender,editTextFaculty,editTextCampus;

    CheckBox agreement;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        editTextRegno= findViewById(R.id.edit_text_regno);
        editTextFirstName=findViewById(R.id.edit_text_first_name);
        editTextLastName=findViewById(R.id.edit_text_last_name);
        editTextGender= findViewById(R.id.edit_text_gender);
        editTextGenderLayout= findViewById(R.id.edit_text_gender_layout);
        editTextCampus= findViewById(R.id.edit_text_campus);
        editTextCampusLayout= findViewById(R.id.edit_text_campus_layout);
        editTextFaculty=findViewById(R.id.edit_text_faculty);
        editTextFacultyLayout=findViewById(R.id.edit_text_faculty_layout);
        editTextPhone=findViewById(R.id.edit_text_phone);
        editTextEmail=findViewById(R.id.edit_text_email);
        editTextPassword=findViewById(R.id.edit_text_password);
        editTextConfirmPassword=findViewById(R.id.edit_text_confirm_password);



        agreement=findViewById(R.id.agreement_checkbox);

        signUpButton=findViewById(R.id.sign_up);

        findViewById(R.id.already_have_an_account_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), LogInActivity.class));
            }
        });

        findViewById(R.id.ib_sign_up_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpActivity.this.finish();


            }
        });

        agreement.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (signUpButton.isEnabled())
                signUpButton.setEnabled(false);
                else {
                    signUpButton.setEnabled(true);
                }
            }
        });





        genderItems = getResources().getStringArray(R.array.gender);
        campusItems = getResources().getStringArray(R.array.campus);
        facultyItems = getResources().getStringArray(R.array.faculty);


        ArrayAdapter genderAdapter = new ArrayAdapter(SignUpActivity.this,R.layout.dropdown_list_item, genderItems);
        genderAdapter.setDropDownViewResource(R.layout.dropdown_list_item);
        editTextGender.setAdapter(genderAdapter);

         ArrayAdapter facultyAdapter = new ArrayAdapter(SignUpActivity.this,R.layout.dropdown_list_item, facultyItems);
        facultyAdapter.setDropDownViewResource(R.layout.dropdown_list_item);
         editTextFaculty.setAdapter(facultyAdapter);

         ArrayAdapter campusAdapter = new ArrayAdapter(SignUpActivity.this,R.layout.dropdown_list_item, campusItems);
         campusAdapter.setDropDownViewResource(R.layout.dropdown_list_item);
         editTextCampus.setAdapter(campusAdapter);




        //if the user is already logged in we will directly start the MainActivity (profile) activity
        if (SharedPreferenceManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
            return;
        }




        findViewById(R.id.sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on button register
                //here we will register the user to server
                registerUser();
            }
        });

        findViewById(R.id.textViewLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on textview that already register open LoginActivity
                finish();
                startActivity(new Intent(SignUpActivity.this, LogInActivity.class));
            }
        });

    }

    private void registerUser() {
        final String regNo = editTextRegno.getEditText().getText().toString().trim();
        final String firstName = editTextFirstName.getEditText().getText().toString().trim();
        final String lastName = editTextLastName.getEditText().getText().toString().trim();
        final String gender = editTextGenderLayout.getEditText().getText().toString().trim();
        final String faculty = editTextFacultyLayout.getEditText().getText().toString().trim();
        final String campus = editTextCampusLayout.getEditText().getText().toString().trim();
        final String phone = editTextPhone.getEditText().getText().toString().trim();
        final String email = editTextEmail.getEditText().getText().toString().trim();
        final String password = editTextPassword.getEditText().getText().toString().trim();
        final String confirmPassword = editTextConfirmPassword.getEditText().getText().toString().trim();




        editTextRegno.setError(null);
        editTextFirstName.setError(null);
        editTextLastName.setError(null);
        editTextGenderLayout.setError(null);
        editTextFacultyLayout.setError(null);
        editTextCampusLayout.setError(null);
        editTextPhone.setError(null);
        editTextEmail.setError(null);
        editTextPassword.setError(null);
        editTextConfirmPassword.setError(null);



        //first we will do the validations
        if (TextUtils.isEmpty(regNo)) {
            editTextRegno.setError("Please enter Regno");
            editTextRegno.requestFocus();
            return;
        } else{
            editTextRegno.setError(null);
        }

        if (TextUtils.isEmpty(firstName)) {
            editTextFirstName.setError("Please enter first name");
            editTextFirstName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(gender)) {
            editTextGenderLayout.setError("Please select gender");
            editTextGenderLayout.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(faculty)) {
            editTextFacultyLayout.setError("Please select your faculty");
            editTextFacultyLayout.requestFocus();
            return;
        }

         if (TextUtils.isEmpty(campus)) {
            editTextCampusLayout.setError("Please select your campus");
            editTextCampusLayout.requestFocus();
            return;
        }

         if (TextUtils.isEmpty(phone)) {
            editTextPhone.setError("Please enter your phone number");
            editTextPhone.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Please enter your email");
            editTextEmail.requestFocus();
            return;
        }
//        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()&&!email.endsWith("@stud.iuiu.ac.ug"))
        if (!email.endsWith("@stud.iuiu.ac.ug")) {
            editTextEmail.setError("Enter a valid school email");
            editTextEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Enter a password");
            editTextPassword.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(confirmPassword)) {
            editTextConfirmPassword.setError("Enter a password");
            editTextConfirmPassword.requestFocus();
            return;
        } else if(!confirmPassword.equals(password)){
            editTextConfirmPassword.setError("Passwords do not match");
            editTextConfirmPassword.requestFocus();
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("tagconvertstr", "["+response+"]");
                        try {


                            //converting response to json object
                            JSONObject obj = new JSONObject(response);
                            //if no error in response
                            if (!obj.getBoolean("error")) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                //getting the user from the response
                                JSONObject userJson = obj.getJSONObject("student");


                                //creating a new student object
                                Student student = new Student(
                                        userJson.getString("reg_no"),
                                        userJson.getString("first_name"),
                                        userJson.getString("last_name"),
                                        userJson.getString("gender"),
                                        userJson.getString("faculty"),
                                        userJson.getString("campus"),
                                        userJson.getString("phone"),
                                        userJson.getString("email"),
                                        userJson.getString("academic_year"),
                                        userJson.getString("title"),
                                        userJson.getString("role"),
                                        userJson.getString("go_id")
                                );

                                //storing the student in shared preferences
                                SharedPreferenceManager.getInstance(getApplicationContext()).studentLogin(student);

                                //starting the profile activity
                                finish();
                                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
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
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("reg_no", regNo);
                params.put("first_name", firstName);
                params.put("last_name", lastName);
                params.put("gender", gender);
                params.put("campus", campus);
                params.put("faculty", faculty);
                params.put("phone", phone);
                params.put("email", email);
                params.put("password", password);

                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}

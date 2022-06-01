package com.example.iusu_app_v3.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.iusu_app_v3.R;
import com.example.iusu_app_v3.SharedPreferenceManager;
import com.example.iusu_app_v3.Models.Student;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.imageview.ShapeableImageView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class ProfileActivity extends AppCompatActivity {
    TextView regno,name,gender,faculty,campus,phone,email;
    ShapeableImageView profileImage;
    BottomNavigationView bottomNavigationView;
    ImageButton imageButton;
    Button imageUpdateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();

        bottomNavigationMethod();

        regno=findViewById(R.id.textViewRegno);
        name=findViewById(R.id.textViewName);
        gender=findViewById(R.id.textViewGender);
        faculty=findViewById(R.id.textViewFaculty);
        campus=findViewById(R.id.textViewCampus);
        phone=findViewById(R.id.textViewPhone);
        email=findViewById(R.id.textViewEmail);

        Student student = SharedPreferenceManager.getInstance(this).getStudent();
        regno.setText(student.getRegNo());
        name.setText(student.getFirstName()+" "+student.getLastName());
        gender.setText(student.getGender());
        faculty.setText(student.getFaculty());
        campus.setText(student.getCampus());
        phone.setText(student.getPhone());
        email.setText(student.getEmail());

        profileImage=findViewById(R.id.image);
        imageUpdateBtn=findViewById(R.id.btn_image_update);


        imageButton=findViewById(R.id.btn_add_image);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withActivity(ProfileActivity.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                CropImage.activity().setGuidelines(CropImageView.Guidelines.ON).setFixAspectRatio(true)
                                        .setAspectRatio(1, 1)
                                        .start(ProfileActivity.this);


                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                                if(permissionDeniedResponse.isPermanentlyDenied()){
                                    AlertDialog.Builder builder=new AlertDialog.Builder(ProfileActivity.this);
                                    builder.setTitle("Permission Required").setMessage("Permission to access storage is required to pick image. Please go to setting to enable permission to access storage")
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    Intent intent = new Intent();
                                                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                                    intent.setData(Uri.fromParts("package",getPackageName(),null));
                                                    startActivityForResult(intent,51);
                                                }
                                            }).setNegativeButton("Cancel",null).show();
                                }
                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                               permissionToken.continuePermissionRequest();
                            }
                        }).check();

            }
        });




    }

    public void bottomNavigationMethod(){

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {


                    case R.id.home:
                        Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.favorites:
                        Intent intent1 = new Intent(ProfileActivity.this,FavoritesActivity.class);
                        startActivity(intent1);
                        overridePendingTransition(0,0);

                        return true;

                    case R.id.help:
                        Intent intent2 = new Intent(ProfileActivity.this,HelpActivity.class);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                profileImage.setImageURI(resultUri);
                imageUpdateBtn.setVisibility(View.VISIBLE);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }


//    private void startCropImageActivity(Uri imageUri) {
//        CropImage.activity(imageUri)
//                .setGuidelines(CropImageView.Guidelines.ON)
//                .setAllowFlipping(false)
//                .setActivityTitle("Crop Image")
//                .setCropMenuCropButtonIcon(R.drawable.ic_baseline_camera_24)
//                .setAllowRotation(true)
//                .setInitialCropWindowPaddingRatio(0)
//                .setFixAspectRatio(true)
//                .setAspectRatio(1, 1)
//                .setOutputCompressQuality(80)
//                .setOutputCompressFormat(Bitmap.CompressFormat.JPEG)
//                .setMultiTouchEnabled(true)
//                .start(this);
//    }





}
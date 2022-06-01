<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SignInActivity"
    android:orientation="vertical"

    android:paddingLeft="28dp"
    android:paddingRight="28dp"
    >


    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:layout_marginBottom="10dp"
        android:drawableLeft="@drawable/ic_baseline_arrow_back_ios_24"
        android:gravity="center_vertical"
        android:padding="5dp"
        android:text="Back"
        android:textSize="14sp"
        android:textColor="#303030"/>

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:padding="5dp">
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="22sp"
                android:layout_marginTop="15dp"
                android:text="Sign in"
                android:textStyle="bold"/>


            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="12sp"
                android:layout_marginTop="30dp"
                android:text="Email"
                />

            <EditText
                android:layout_width="match_parent"
                android:layout_height="48dp"
                android:background="@drawable/custom_edit_text_bg"
                android:hint="Enter email"
                android:paddingLeft="18dp"
                android:paddingTop="10dp"
                android:paddingBottom="10dp"
                android:textSize="14sp"
                android:inputType="textEmailAddress"/>


            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="12sp"
                android:layout_marginTop="15dp"
                android:text="Password"/>

            <EditText
                android:layout_width="match_parent"
                android:layout_height="48dp"
                android:background="@drawable/custom_edit_text_bg"
                android:hint="Enter password"
                android:paddingLeft="18dp"
                android:padd
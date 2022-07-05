package com.example.iusu_app_v3.Models;

public class Student {


  private String regNo, firstName, lastName, gender, faculty, campus, phone, email,academicYear,guildTitle,guildRole;
  private String go_id;


  public Student(String regNo, String firstName, String lastName, String gender, String faculty, String campus, String phone, String email, String academicYear, String guildTitle, String guildRole, String go_id) {
    this.regNo = regNo;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.faculty = faculty;
    this.campus = campus;
    this.phone = phone;
    this.email = email;
    this.academicYear = academicYear;
    this.guildTitle = guildTitle;
    this.guildRole = guildRole;
    this.go_id = go_id;
  }

  public String getRegNo() {
    return regNo;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getGender() {
    return gender;
  }

  public String getFaculty() {
    return faculty;
  }

  public String getCampus() {
    return campus;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getAcademicYear() {
    return academicYear;
  }

  public String getGuildTitle() {
    return guildTitle;
  }

  public String getGuildRole() {
    return guildRole;
  }

  public String getGo_id() {
    return go_id;
  }
}

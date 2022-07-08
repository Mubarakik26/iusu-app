package com.example.iusu_app_v3.Models;

public class GuildOfficial {
    private String firstName, lastName,campus, phone, email,profilemage,goId,academicYear,guildTitle,guildRole;

//

    public GuildOfficial( String firstName, String lastName, String campus, String phone, String email,String profilemage, String goId, String academicYear, String guildTitle, String guildRole) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.campus = campus;
        this.phone = phone;
        this.email = email;
        this.profilemage=profilemage;
        this.goId = goId;
        this.academicYear = academicYear;
        this.guildTitle = guildTitle;
        this.guildRole = guildRole;

    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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


    public String getProfilemage() {
        return profilemage;
    }

    public String getGoId() {
        return goId;
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


}

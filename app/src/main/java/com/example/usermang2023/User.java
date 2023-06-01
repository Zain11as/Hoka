package com.example.usermang2023;

public class User {
    private String Firstname;
    private String Lastname;
    private String country;
    private String city;
    private String Jobyouneed;
    private String phone;

    public User(){}
    public User(String city,String Firstname, String Lastname, String country,String Jobyouneed,String phone) {
        this.city = city;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.country = country;
        this.Jobyouneed = Jobyouneed;
        this.phone = phone;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getJobyouneed() {
        return Jobyouneed;
    }

    public void setJobyouneed(String jobyouneed) {
        Jobyouneed = jobyouneed;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", Jobyouneed='" + Jobyouneed + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
